package hanium.ets.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;


/**
 * ������ ��ť��Ƽ���� �α��� ���н� ȣ��Ǵ� EventHandler
 * springBean ������������
 *  security:form-login �±׿� authentication-failure-handler-ref �߰��ϸ�
 * �α��� ���н� onAuthenticationFailure �޼ҵ� �ڵ� ȣ��
 * */
@Component //id="memberAuthenticationFailureHandler"
public class MemberAuthenticationFailureHandler implements AuthenticationFailureHandler{

	@Override
	public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse res, AuthenticationException auth)
			throws IOException, ServletException {
		req.setAttribute("errorMessage", auth.getMessage()); // �����޼��� �߰�
		req.getRequestDispatcher("/error").forward(req, res); // error�������� forward ���·� �̵�
		
	}

	
	
}