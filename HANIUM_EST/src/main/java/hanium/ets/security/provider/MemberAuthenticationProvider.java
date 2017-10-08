package hanium.ets.security.provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import hanium.ets.dao.MemberDAO;
import hanium.ets.dto.AuthorityDTO;
import hanium.ets.dto.MemberDTO;

/**
 * ������ ��ť��Ƽ ������ ó���ϴ� Provider
 */
@Service //id="memberAuthenticationProvider"
public class MemberAuthenticationProvider implements AuthenticationProvider{
		
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		
		// ���� ó���� �� �� ���� ���
		if(!supports(auth.getClass())){
			return null;
		}
		
		// 1. �μ��� ���� ���� ������ ������ ��� �����ϴ��� üũ
		
		String id = auth.getName();
		MemberDTO member = memberDAO.checkId(new MemberDTO(id, null, null));
		
		if(member==null){// id�� ���� ��� 
			throw new UsernameNotFoundException("No member information!");
		}
		
		// 2. �����ϸ� ��й�ȣ ��
		String password = (String)auth.getCredentials();
		
		
		if(!passwordEncoder.matches(password, member.getPassword())){
			throw new BadCredentialsException("Password is incorrect!");
		}
		
		////////////// ������ ������ �� ./////////////////
		// 3. ��� ��ġ�ϸ� Authentication�� ���� ���� 
		List<AuthorityDTO> list = memberDAO.selectAuth(id);
		
		if(list.isEmpty()){
			//�ƹ� ������ ���� ���
			throw new UsernameNotFoundException("You do not have permission!");
		}
		
		// db���� ������ �� ������ GrantedAuthority�� ��ȯ �ؾ���
		List<SimpleGrantedAuthority> authList = new ArrayList<>();
		for(AuthorityDTO authority : list){
			authList.add(new SimpleGrantedAuthority(authority.getRole()));
		}
		
		return new UsernamePasswordAuthenticationToken(member, null, authList);
	}

	/**
	 * �ش� Ÿ���� authentication ��ü�� �̿��ؼ� ���� ó���� �� �� �ִ��� ���θ� �������ִ� �޼ҵ�
	 * */
	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
