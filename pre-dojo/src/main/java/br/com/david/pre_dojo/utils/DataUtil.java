package br.com.david.pre_dojo.utils;

import java.util.Calendar;
import java.util.Date;

public class DataUtil {

	/**
	 * validar se as duas datas passadas estão dentro de um mesmo minuto.
	 * 
	 * @param data
	 * @param data2
	 * @return
	 */
	public boolean dentroDeUmMinuto(Date data, Date data2) {

		Calendar c1 = Calendar.getInstance();
		c1.setTime(data);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(data2);

		c1.add(Calendar.MINUTE, 1);

		return c1.after(c2);
	}

}
