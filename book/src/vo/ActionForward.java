package vo;

public class ActionForward {
	/*
	 * �������� Ŭ���̾�Ʈ�κ����� ��û�� �޾� ó���� �� View �������� �̵�(������)�� ��
	 * �̵��� View �������� URL(�ּ�)�� �������� ���(Dispatch �Ǵ� Redirect) �� �ٷ�� ���� Ŭ����
	 * => �ּ� ���� ������ ������ ��� ���� ���� �� Getter/Setter �� ����
	 */
	private String path; // ���� ��û ó�� �� ������ �� View �������� URL(�ּ�) ������ ����
	private boolean isRedirect; // ������ �� ����� ������ ����(true : Redirect ���, false : Dispatch ���)
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
}
