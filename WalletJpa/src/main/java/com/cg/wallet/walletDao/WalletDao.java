package com.cg.wallet.walletDao;


import java.sql.Connection;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


import com.cg.wallet.bean.Wallet;
import com.cg.wallet.walletException.WalletException;

/**
 * 
 * Class name : WalletDao
 * Interface : IWalletDao
 * No. of Methods : 6
 * Purpose :To access the database and retrieve values from database
 * 
 * Author : Narmatha
 * Date of Creation : 04-August-2018
 * 
 * Last Modification Date : 04-August-2018
 *
 */

public class WalletDao implements IWalletDao {
	
	
	protected EntityManager em;

	public WalletDao(EntityManager em){

			this.em=em;
		
	}
	@Override
	
	public String createAccount(Wallet wallet) throws WalletException {
		em.getTransaction().begin();
		
		em.persist(wallet);
		em.getTransaction().commit();
		return wallet.getMobileNo();	 


	}}
	/*@Override
	public double showBalance(String mobileNo)
			throws WalletException {
		Connection conn=WalletDataBase.getConn();
		Wallet wallet=new Wallet();
		PreparedStatement stat;
		try{
			stat=conn.prepareStatement(IQueryMapper.getBal);
			stat.setString(1, mobileNo);
			ResultSet rs=stat.executeQuery();
			conn.commit();
			if(rs!=null){
				rs.next();
				return rs.getDouble("balance");
			}else{
				throw new WalletException("mobile no does not exists");
			}
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new WalletException(e.getMessage());
		}
	}

	@Override
	public Wallet deposit(String mobileNo,double dep)
			throws WalletException {
		Connection conn=WalletDataBase.getConn();
		PreparedStatement stat;
		PreparedStatement stat1;
		try{
		 
		stat=conn.prepareStatement(IQueryMapper.getacc);
		stat.setString(1, mobileNo);
		ResultSet rs=stat.executeQuery();
		if(rs!=null){
		rs.next();
		Wallet wallet=new Wallet();
		double balance=rs.getDouble("balance")+dep;
		wallet.setName(rs.getString("name"));
		wallet.setMobileNo(rs.getString("mobileNo"));
		wallet.setBalance(balance);
		wallet.setEmailId(rs.getString("emailId"));
		wallet.setDate(Date.valueOf(LocalDate.now()));
		 
		stat1=conn.prepareStatement(IQueryMapper.depo);
		stat1.setDouble(1, wallet.getBalance());
		stat1.setDate(2, wallet.getDate());
		stat1.setString(3, wallet.getMobileNo());
		int rs1=stat1.executeUpdate();
		 
		 
		if(rs1==1){
		 
		conn.commit();
		 
		return wallet;
		}else{
		throw new WalletException("Balance Cannot be Updated");
		}
		 
		}
		else{
		throw new WalletException("Invalid mobile number");
		}
		 
		 
		}catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new WalletException(e.getMessage());
		}
		 

	}
		
	@Override
	public Wallet withdrawAmount(String mobileNo,double withdraw)
			throws WalletException {
		Connection conn=WalletDataBase.getConn();
		Wallet wallet=new Wallet();
		PreparedStatement stat;
		PreparedStatement stat1;
		try{
		 
		stat=conn.prepareStatement(IQueryMapper.getacc);
		stat.setString(1, mobileNo);
		ResultSet rs=stat.executeQuery();
		if(rs!=null){
		rs.next();
		
		double balance=rs.getDouble("balance")-withdraw;
		wallet.setName(rs.getString("name"));
		wallet.setMobileNo(rs.getString("mobileNo"));
		wallet.setBalance(balance);
		wallet.setEmailId(rs.getString("emailId"));
		wallet.setDate(Date.valueOf(LocalDate.now()));
		
		stat1=conn.prepareStatement(IQueryMapper.withD);
		stat1.setDouble(1, wallet.getBalance());
		stat1.setDate(2, wallet.getDate());
		stat1.setString(3, wallet.getMobileNo());
		int rs1=stat1.executeUpdate();
		 
		 
		if(rs1==1){
		conn.commit();
		return wallet;
		}else{
		throw new WalletException("Invalid Mobile Number");
		}

		}
		else{
		throw new WalletException("Mobile number does not exists");
		}
		 
		 
		}catch (SQLException e) {
	
		throw new WalletException(e.getMessage());
		}

	}

	@Override
	public double fundTransfer(String srcMobile, String destMobile,
			double amount) throws WalletException {
		Connection conn=WalletDataBase.getConn();
		Wallet wallet=new Wallet();
		Wallet wallet2=new Wallet();
		deposit(srcMobile, amount);
		withdrawAmount(destMobile, amount);
		Wallet wallet=wallMap.get(srcMobile);
		Wallet wallet2=wallMap.get(destMobile);
		if(wallMap.containsKey(wallet.getMobileNo())){
			if(wallMap.containsKey(wallet2.getMobileNo())){
				while(wallet.getBalance()>amount)
				wallet.setBalance(wallet.getBalance()-amount);
				wallet2.setBalance(wallet2.getBalance()+amount);
			
			
		
		return wallet.getBalance()+wallet2.getBalance();
	}

	@Override
	public Wallet printTransaction(String mobile) throws WalletException {
		Connection conn=WalletDataBase.getConn();
		PreparedStatement stat;
		try{
		stat=conn.prepareStatement(IQueryMapper.getacc);
		stat.setString(1, mobile);
		ResultSet rs=stat.executeQuery();
		conn.commit();
		if(rs!=null){
		rs.next();
		Wallet wallet=new Wallet();
		wallet.setName(rs.getString("name"));
		wallet.setMobileNo(rs.getString("mobileNo"));
		wallet.setEmailId(rs.getString("emailId"));
		wallet.setBalance(rs.getDouble("balance"));
		wallet.setDate(rs.getDate("Trans_date"));
		return wallet;
		}else{
		throw new WalletException("Mobile number does not exists");
		}
		 
		 
		}catch (SQLException e) {

		throw new WalletException(e.getMessage());
		}
	}
	
	
	

}
*/