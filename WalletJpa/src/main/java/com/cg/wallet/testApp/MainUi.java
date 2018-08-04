package com.cg.wallet.testApp;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.wallet.bean.Wallet;
import com.cg.wallet.walletDao.IWalletDao;
import com.cg.wallet.walletDao.WalletDao;
import com.cg.wallet.walletException.WalletException;
import com.cg.wallet.walletService.IWalletService;
import com.cg.wallet.walletService.WalletServiceImpl;
/**
 * 
 * Class name : Wallet
 * No. of Methods : 2
 * Purpose : Main Class to do testing
 * 
 * Author : Narmatha
 * Date of Creation : 04-August-2018
 * 
 * Last Modification Date : 04-August-2018
 *
 */
public class MainUi {

	public static void main(String[] args) {
		
EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		
		
		EntityManager em = emf.createEntityManager();
		IWalletDao dao=new WalletDao(em);
		IWalletService service=new WalletServiceImpl(dao);
		Wallet wallet= new Wallet();
		wallet.setName("Ravan");
		wallet.setMobileNo("1234567890");
		wallet.setEmailId("ravan@gmail.com");
		wallet.setBalance(1000.0);
		try {
			service.createAccount(wallet);
			System.out.println("Account created");
			
		} catch (WalletException e) {
			System.out.println("invalid");
			System.out.println(e.getMessage());
			System.out.println();
		}
		
		/*wallet.setMobileNo("7788665533");
		try {
			System.out.println(ser.showBalance(wallet.getMobileNo()));
		} catch (WalletException e) {
			System.out.println("invalid");
			System.out.println(e.getMessage());
			System.out.println();
		}
*/
	}

}
