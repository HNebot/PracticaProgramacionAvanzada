package salida;

import interfaces.IntSalidaInfo;

public class SalidaInfoConsola implements IntSalidaInfo{

	@Override
	public void salidaInfo(String info) {
		System.out.println(info);
		
	}

}
