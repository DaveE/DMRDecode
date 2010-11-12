package com.dmr;

public class DMRVoice {
	private String line[]=new String[10];
	private boolean res;
	
	public String[] decode (DMRDecode theApp,byte[] dibit_buf)	{
		String cline;
		DecodeCACH cachdecode=new DecodeCACH();
		line[0]="<b>"+theApp.getTimeStamp()+" DMR Voice Frame </b>";
		// CACH decode
		cline=cachdecode.decode(theApp,dibit_buf);
		res=cachdecode.isPassErrorCheck();
		if (res==true) line[1]=cline;
		theApp.frameCount++;
		return line;
	}

	public boolean isError() {
		return res;
	}

}
