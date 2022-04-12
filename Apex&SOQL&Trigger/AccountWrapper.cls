public class AccountWrapper implements Comparable {
   public Account account;
   public AccountWrapper(Account acc){
        account = acc;
    } 
    
   public Integer compareTo(Object compareTo){
        AccountWrapper otherAccount = (AccountWrapper) compareTo;
        Integer returnValue = 0;
        if (account.Revenue__c > otherAccount.account.Revenue__c) {
            // Set return value to a positive value.
            returnValue = 1;
        } else if (account.Revenue__c < otherAccount.account.Revenue__c) {
            // Set return value to a negative value.
            returnValue = -1;
        } else if ((account.Revenue__c == null) && (otherAccount.account.Revenue__c != null)){
            // nulls-first implementation
            returnValue = -1;
        } else if ((account.Revenue__c != null) && (otherAccount.account.Revenue__c == null)){
            // nulls-first implementation
            returnValue = 1;
        }        
        return returnValue;   
    }
}