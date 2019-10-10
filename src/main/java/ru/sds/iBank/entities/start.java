package ru.sds.iBank.entities;

import java.util.Date;

import ru.sds.iBank.dao.impl.Dao;
import ru.sds.iBank.services.impl.Service;

public class start {
	public static void main(String[] args) {
	
	Client client = new Client(0, "Dima", "Scheglov", "Sergeevich", new Date(1996, 11, 06), new Date(2019, 9, 24), "shheglov1996@mail.ru", "shheglo1996v");
	System.out.println(client);
	
	//Card card = new Card(0, "1234", "cardOne", new Date(2019, 9, 24), null, new Account(0, "12345", "accountOne", new Date(2019, 9, 24), null, 90000, client), client);
	//System.out.println(card);
	
	Dao dao = new Dao();
	System.out.println(dao.getClientByLogin("shheg"));
	
	Service service = new Service();
	service.setDao(dao);
	
	System.out.println(service.isLogin("shheg23", "shheglo1996v"));
	
	System.out.println(service.getClientByLogin("shheg"));
	System.out.println(service.getClientById(1));
	
	
	System.out.println(dao.getClientById(1));
	
	System.out.println(dao.getAccountById(2));
	
	System.out.println(dao.getAccountsByClientId(1));
	
	System.out.println(dao.getCardsByClientId(1));
	
	//PayDocument payDocument = new PayDocument(1, 12133, new Date(2019, 9, 24), 100, "просто", "12133", "12133123");
	
	//System.out.println(dao.updateWritteOff(payDocument));
	
	PayDocument payDocument = new PayDocument(1, 12133, new Date(2019, 9, 24), 900, "просто", "12133", "121212");
	//System.out.println(dao.updateEnrollment(payDocument));
	System.out.println(dao.doPayment(payDocument));
	System.out.println(dao.getCardByNumber("567891"));
	
	System.out.println(dao.getCardById(2));
	System.out.println(dao.getPayDocumentById(1));
}
}
