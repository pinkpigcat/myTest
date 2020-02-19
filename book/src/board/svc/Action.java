package board.svc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;


public interface Action {
	/*
	 * XXXAction Ŭ�����κ��� ��û�� ���� ��
	 * ���� �ٸ� Ŭ������κ����� ��û�̹Ƿ� ������ Ÿ������ ó���� �����ؾ��Ѵ�.
	 * => �̸� ������ ������ Ȱ���� ���� �ϳ��� Ÿ������ ó���ϱ� ���� Action �������̽� ����
	 *    �� ��û�� �޾Ƶ��� execute() �޼��带 �������� �����Ͽ� ��û(request), ����(response) ��ü ���޹���
	 * => execute() �޼��� ���� �� ������ �ּҿ� ������ ����� ������ ActionForward ��ü�� ����
	 */
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
