package kr.co.jhta.exception;

public class DuplicatedMemberIdException  extends JhtaException{
	
	private static final long serialVersionUID = 686508286460442223L;

	public DuplicatedMemberIdException(String message) {
		super(message);
	}

}
