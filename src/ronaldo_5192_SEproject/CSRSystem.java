package ronaldo_5192_SEproject;

import java.sql.*;
import java.util.ArrayList;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class CSRSystem {
	
	static ArrayList<BankTransfer> bankTransfer = new ArrayList<BankTransfer>();
	static ArrayList<Contestation> contestations = new ArrayList<Contestation>();
	static ArrayList<CreditCard> creditCards = new ArrayList<CreditCard>();

	static ArrayList<Customer> customers = new ArrayList<Customer>();
	static ArrayList<Debt> debts = new ArrayList<Debt>();
	static ArrayList<Installment> installments = new ArrayList<Installment>();
	
	public static void main(String[] args) {

		try {
			// getting the connection with database
			Connection conn = ConnectionManager.getConnection();
			Statement stmt  = conn.createStatement();
			ResultSet rs = null;

			// CONTESTATIONS
			String sqlContestation = "SELECT * FROM tbContestation;";
			rs = stmt.executeQuery(sqlContestation);
		              
			while (rs.next())
				contestations.add(new Contestation(rs.getString("issue"), rs.getString("dateStart"), rs.getString("dateEnd"), rs.getString("content"), rs.getString("conclusion")));
			
			// CREDIT CARDS
			String sqlCreditCard = "SELECT * FROM tbCreditCard AS cc INNER JOIN tbPayment AS pa ON cc.pkCreditCard = pa.fkCreditCard;";
			rs = stmt.executeQuery(sqlCreditCard);
		              
			while (rs.next())
				creditCards.add(new CreditCard(rs.getDouble("valuePayment"), rs.getString("typePayment"), rs.getString("datePayment"), rs.getBoolean("recurrent"), rs.getString("number"), 
						rs.getString("name"), rs.getString("expireDate"), rs.getString("cvc"), rs.getString("brand")));
			
			// BANK TRANSFER
			String sqlBankTransfer = "SELECT * FROM tbBankTransfer AS bt INNER JOIN tbPayment AS pa ON bt.pkBankTransfer = pa.fkBankTransfer";
			rs = stmt.executeQuery(sqlBankTransfer);
		              
			while (rs.next())
				bankTransfer.add(new BankTransfer(rs.getDouble("valuePayment"), rs.getString("typePayment"), rs.getString("datePayment"), rs.getBoolean("recurrent"), rs.getString("name"), 
						rs.getString("branch"), rs.getString("bank"), rs.getString("accountNumber"), rs.getString("branchNumber")));

			// CUSTOMERS
			String sqlCustomer = "SELECT * FROM tbCustomer;";
			rs = stmt.executeQuery(sqlCustomer);
		              
			while (rs.next()) {
				
				int pkCustomer = rs.getInt("pkCustomer");
				
				Customer customer = new Customer(rs.getString("firstName"), rs.getString("lastName"), rs.getString("birthDate"), rs.getString("firstPurchaseDate"), 
						rs.getString("lastPurchaseDate"), rs.getInt("numPurchases"), rs.getString("city"), rs.getString("state"));

				// including DEBT into CUSTOMER
				String sqlCustomerDebt = "SELECT * FROM tbDebt WHERE fkCustomer = '" + pkCustomer + "';";
				Statement stmtDebt  = conn.createStatement();
				ResultSet rsDebt = stmtDebt.executeQuery(sqlCustomerDebt);
				
				while (rsDebt.next()) 
				{
					
					int pkDebt = rsDebt.getInt("pkDebt");
					
					Debt debtTemp = new Debt(rsDebt.getString("typeDebt"), rsDebt.getString("dateDebt"), rsDebt.getFloat("valueDebt"));
					
					// including INSTALLMENT into DEBT				
					String sqlDebtInstallment = "SELECT * FROM tbInstallments WHERE fkDebt = '" + pkDebt + "';";
					Statement stmtInstallment  = conn.createStatement();
					ResultSet rsInstallment = stmtInstallment.executeQuery(sqlDebtInstallment);
					
					while (rsInstallment.next())
						debtTemp.addInstallment(new Installment(rsInstallment.getString("dateInstallment"), rsInstallment.getFloat("valueInstallment"), 
								rsInstallment.getString("firstPayment"), rsInstallment.getString("frequency")));
						
					// including CONSTESTATION into DEBT				
					String sqlDebtContestation = "SELECT * FROM tbContestation WHERE fkDebt = '" + pkDebt + "';";
					Statement stmtContestation  = conn.createStatement();
					ResultSet rsContestation = stmtContestation.executeQuery(sqlDebtContestation);
					
					while (rsContestation.next())
						debtTemp.addContestation(new Contestation(rsContestation.getString("issue"), rsContestation.getString("dateStart"), 
								rsContestation.getString("dateEnd"), rsContestation.getString("content"), rsContestation.getString("conclusion")));

					// including PAYMENT - CREDIT CARD into DEBT
					String sqlDebtCreditCard = "SELECT * "
						+ "FROM tbCreditCard AS cd "
							+ "INNER JOIN tbPayment AS pa ON cd.pkCreditCard = pa.fkCreditCard "
							+ "INNER JOIN tbDebt AS de ON pa.pkPayment = de.fkPayment "
						+ "WHERE pkDebt = '" + pkDebt + "';";
					
					Statement stmtDebtCreditCard  = conn.createStatement();
					ResultSet rsDebtCreditCard = stmtDebtCreditCard.executeQuery(sqlDebtCreditCard);
					
					while (rsDebtCreditCard.next())
						debtTemp.setPaymentMethod(new CreditCard(rsDebtCreditCard.getDouble("valuePayment"), rsDebtCreditCard.getString("typePayment"), 
							rsDebtCreditCard.getString("datePayment"), rsDebtCreditCard.getBoolean("recurrent"), rsDebtCreditCard.getString("number"), 
							rsDebtCreditCard.getString("name"), rsDebtCreditCard.getString("expireDate"), rsDebtCreditCard.getString("cvc"), 
							rsDebtCreditCard.getString("brand")));
					
					// including PAYMENT - BANK TRANSFER into DEBT
					String sqlDebtBankTransfer = "SELECT * "
							+ "FROM tbBankTransfer AS bf "
								+ "INNER JOIN tbPayment AS pa ON bf.pkBankTransfer = pa.fkBankTransfer "
								+ "INNER JOIN tbDebt AS de ON pa.pkPayment = de.fkPayment "
							+ "WHERE pkDebt = '" + pkDebt + "';";

					Statement stmtDebtBankTransfer  = conn.createStatement();
					ResultSet rsDebtBankTransfer = stmtDebtBankTransfer.executeQuery(sqlDebtBankTransfer);
					
					while (rsDebtBankTransfer.next())
						debtTemp.setPaymentMethod(new BankTransfer(rsDebtBankTransfer.getDouble("valuePayment"), rsDebtBankTransfer.getString("typePayment"), 
							rsDebtBankTransfer.getString("datePayment"), rsDebtBankTransfer.getBoolean("recurrent"), rsDebtBankTransfer.getString("name"), 
							rsDebtBankTransfer.getString("branch"), rsDebtBankTransfer.getString("bank"), rsDebtBankTransfer.getString("accountNumber"), 
							rsDebtBankTransfer.getString("branchNumber")));
					
					// Add Debt into Customer
					customer.addDebt(debtTemp);					
				}
				
				customers.add(customer);	
			}				
						
			// DEBTS
			String sqlDebt = "SELECT * FROM tbDebt;";
			rs = stmt.executeQuery(sqlDebt);
			
			while (rs.next()) {
				
				int pkDebt = rs.getInt("pkDebt");
				
				Debt debt = new Debt(rs.getString("typeDebt"), rs.getString("dateDebt"), rs.getFloat("valueDebt"));
				
				// including INSTALLMENT into DEBT				
				String sqlDebtInstallment = "SELECT * FROM tbInstallments WHERE fkDebt = '" + pkDebt + "';";
				Statement stmtInstallment  = conn.createStatement();
				ResultSet rsInstallment = stmtInstallment.executeQuery(sqlDebtInstallment);
				
				while (rsInstallment.next())
					debt.addInstallment(new Installment(rsInstallment.getString("dateInstallment"), rsInstallment.getFloat("valueInstallment"), 
							rsInstallment.getString("firstPayment"), rsInstallment.getString("frequency")));
					
				// including CONSTESTATION into DEBT				
				String sqlDebtContestation = "SELECT * FROM tbContestation WHERE fkDebt = '" + pkDebt + "';";
				Statement stmtContestation  = conn.createStatement();
				ResultSet rsContestation = stmtContestation.executeQuery(sqlDebtContestation);
				
				while (rsContestation.next())
					debt.addContestation(new Contestation(rsContestation.getString("issue"), rsContestation.getString("dateStart"), 
							rsContestation.getString("dateEnd"), rsContestation.getString("content"), rsContestation.getString("conclusion")));

				// including PAYMENT - CREDIT CARD into DEBT
				String sqlDebtCreditCard = "SELECT * "
					+ "FROM tbCreditCard AS cd "
						+ "INNER JOIN tbPayment AS pa ON cd.pkCreditCard = pa.fkCreditCard "
						+ "INNER JOIN tbDebt AS de ON pa.pkPayment = de.fkPayment "
					+ "WHERE pkDebt = '" + pkDebt + "';";
				
				Statement stmtDebtCreditCard  = conn.createStatement();
				ResultSet rsDebtCreditCard = stmtDebtCreditCard.executeQuery(sqlDebtCreditCard);
				
				while (rsDebtCreditCard.next())
					debt.setPaymentMethod(new CreditCard(rsDebtCreditCard.getDouble("valuePayment"), rsDebtCreditCard.getString("typePayment"), 
						rsDebtCreditCard.getString("datePayment"), rsDebtCreditCard.getBoolean("recurrent"), rsDebtCreditCard.getString("number"), 
						rsDebtCreditCard.getString("name"), rsDebtCreditCard.getString("expireDate"), rsDebtCreditCard.getString("cvc"), 
						rsDebtCreditCard.getString("brand")));
				
				// including PAYMENT - BANK TRANSFER into DEBT
				String sqlDebtBankTransfer = "SELECT * "
						+ "FROM tbBankTransfer AS bf "
							+ "INNER JOIN tbPayment AS pa ON bf.pkBankTransfer = pa.fkBankTransfer "
							+ "INNER JOIN tbDebt AS de ON pa.pkPayment = de.fkPayment "
						+ "WHERE pkDebt = '" + pkDebt + "';";

				Statement stmtDebtBankTransfer  = conn.createStatement();
				ResultSet rsDebtBankTransfer = stmtDebtBankTransfer.executeQuery(sqlDebtBankTransfer);
				
				while (rsDebtBankTransfer.next())
					debt.setPaymentMethod(new BankTransfer(rsDebtBankTransfer.getDouble("valuePayment"), rsDebtBankTransfer.getString("typePayment"), 
						rsDebtBankTransfer.getString("datePayment"), rsDebtBankTransfer.getBoolean("recurrent"), rsDebtBankTransfer.getString("name"), 
						rsDebtBankTransfer.getString("branch"), rsDebtBankTransfer.getString("bank"), rsDebtBankTransfer.getString("accountNumber"), 
						rsDebtBankTransfer.getString("branchNumber")));							
							
				debts.add(debt);					
			}
				
			// INSTALLMENTS
			String sqlInstallment = "SELECT * FROM tbInstallments;";
			rs = stmt.executeQuery(sqlInstallment);
			
			while (rs.next()) {
				
				int pkInstallment = rs.getInt("pkInstallments");
				
				Installment installment = new Installment(rs.getString("dateInstallment"), rs.getFloat("valueInstallment"), rs.getString("firstPayment"), rs.getString("frequency"));
				
				// including CRITERIA into INSTALLMENT
				String sqlInstallmentCriteria = "SELECT * "
						+ "FROM tbInstallments AS it "
							+ "INNER JOIN tbInstallments_tbCriteria AS ic ON it.pkInstallments = ic.fkInstallments "
							+ "INNER JOIN tbCriteria AS cr ON ic.fkCriteria = cr.pkCriteria "
						+ "WHERE pkInstallments = '" + pkInstallment + "';";
				Statement stmtInstallmentCriteria  = conn.createStatement();
				ResultSet rsInstallmentCriteria = stmtInstallmentCriteria.executeQuery(sqlInstallmentCriteria);
				
				while (rsInstallmentCriteria.next())
					installment.addCriteria(new Criteria (rsInstallmentCriteria.getString("typeProgram"), rsInstallmentCriteria.getString("startProgram"), 
							rsInstallmentCriteria.getString("endProgram"), rsInstallmentCriteria.getString("frequency")));
					
				installments.add(installment);					
			}
				
			
			// DASHBOARD
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			
			Dashboard dashboard = new Dashboard("SE Project", "1 hour", dtf.format(now));
			dashboard.setCustomers(customers);
			dashboard.setDebts(debts);
			dashboard.setInstallments(installments);
			dashboard.generateDashboard();
		} 
		catch (SQLException e) {
		    System.out.println(e.getMessage());  
		}
	}
}