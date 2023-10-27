package data.net;

public class LandPrice {
	private int seq;
	private String pnu;
	private String ldCode;
	private String ldCodeNm;
	private int regstrSeCode;
	private String regstrSeCodeNm;
	private int mnnmSlno;
	private int stdrYear;
	private int stdrMt;
	private int PblntfPclnd;
	private String pblntfDe;
	private String stdLandAt;
	private String lastUpdtDt;
	
	public LandPrice() {
		super();
	}

	public LandPrice(int seq, String pnu, String ldCode, String ldCodeNm, int regstrSeCode, String regstrSeCodeNm,
			int mnnmSlno, int stdrYear, int stdrMt, int PblntfPclnd, String pblntfDe, String stdLandAt,
			String lastUpdtDt) {
		super();
		this.seq = seq;
		this.pnu = pnu;
		this.ldCode = ldCode;
		this.ldCodeNm = ldCodeNm;
		this.regstrSeCode = regstrSeCode;
		this.regstrSeCodeNm = regstrSeCodeNm;
		this.mnnmSlno = mnnmSlno;
		this.stdrYear = stdrYear;
		this.stdrMt = stdrMt;
		this.PblntfPclnd = PblntfPclnd;
		this.pblntfDe = pblntfDe;
		this.stdLandAt = stdLandAt;
		this.lastUpdtDt = lastUpdtDt;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getPnu() {
		return pnu;
	}

	public void setPnu(String pnu) {
		this.pnu = pnu;
	}

	public String getLdCode() {
		return ldCode;
	}

	public void setLdCode(String ldCode) {
		this.ldCode = ldCode;
	}

	public String getLdCodeNm() {
		return ldCodeNm;
	}

	public void setLdCodeNm(String ldCodeNm) {
		this.ldCodeNm = ldCodeNm;
	}

	public int getRegstrSeCode() {
		return regstrSeCode;
	}

	public void setRegstrSeCode(int regstrSeCode) {
		this.regstrSeCode = regstrSeCode;
	}

	public String getRegstrSeCodeNm() {
		return regstrSeCodeNm;
	}

	public void setRegstrSeCodeNm(String regstrSeCodeNm) {
		this.regstrSeCodeNm = regstrSeCodeNm;
	}

	public int getMnnmSlno() {
		return mnnmSlno;
	}

	public void setMnnmSlno(int mnnmSlno) {
		this.mnnmSlno = mnnmSlno;
	}

	public int getStdrYear() {
		return stdrYear;
	}

	public void setStdrYear(int stdrYear) {
		this.stdrYear = stdrYear;
	}

	public int getStdrMt() {
		return stdrMt;
	}

	public void setStdrMt(int stdrMt) {
		this.stdrMt = stdrMt;
	}

	public int getPblntfPclnd() {
		return PblntfPclnd;
	}

	public void setPblntfPclnd(int PblntfPclnd) {
		this.PblntfPclnd = PblntfPclnd;
	}

	public String getPblntfDe() {
		return pblntfDe;
	}

	public void setPblntfDe(String pblntfDe) {
		this.pblntfDe = pblntfDe;
	}

	public String getStdLandAt() {
		return stdLandAt;
	}

	public void setStdLandAt(String stdLandAt) {
		this.stdLandAt = stdLandAt;
	}

	public String getLastUpdtDt() {
		return lastUpdtDt;
	}

	public void setLastUpdtDt(String lastUpdtDt) {
		this.lastUpdtDt = lastUpdtDt;
	}

	@Override
	public String toString() {
		return "LandPrice [seq=" + seq + ", pnu=" + pnu + ", ldCode=" + ldCode + ", ldCodeNm=" + ldCodeNm
				+ ", regstrSeCode=" + regstrSeCode + ", regstrSeCodeNm=" + regstrSeCodeNm + ", mnnmSlno=" + mnnmSlno
				+ ", stdrYear=" + stdrYear + ", stdrMt=" + stdrMt + ", PblntfPclnd=" + PblntfPclnd + ", pblntfDe="
				+ pblntfDe + ", stdLandAt=" + stdLandAt + ", lastUpdtDt=" + lastUpdtDt + "]";
	}
}
