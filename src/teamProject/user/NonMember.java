package teamProject.user;

import java.util.Objects;

public class NonMember {
	String checkNonMember;
	String ticketCheckStr; // 예매한 티켓 내용
	

	public NonMember(String checkNonMember, String ticketCheckStr) {
		this.checkNonMember = checkNonMember;
		this.ticketCheckStr = ticketCheckStr;
	}

	public String getCheckNonMember() {
		return checkNonMember;
	}
	
	public String getTicketCheckStr() {
		return ticketCheckStr;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(checkNonMember);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NonMember other = (NonMember) obj;
		return checkNonMember == other.checkNonMember;
	}
	

	@Override
	public String toString() {
		return "예매 번호 : " + checkNonMember + ", 예매 내역 : " + ticketCheckStr;
	}
	
}
