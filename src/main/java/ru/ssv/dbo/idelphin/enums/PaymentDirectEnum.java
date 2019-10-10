package ru.ssv.dbo.idelphin.enums;

public enum PaymentDirectEnum {
	ALL {
		public String getName() {return "ВСЕ";}
	},
	DEBIT {
		public String getName() {return "СПИСАНИЕ";}
	},
	CREDIT {
		public String getName() {return "ПОСТУПЛЕНИЕ";}
	};
	
	public abstract String getName();
}
