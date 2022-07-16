package org.example;

public class User {
        private int userId;
        private String userName;
        private String emailAddress;
        private String password;


        public User(int userId,String userName,String emailAddress,String password){
            this.userId = userId;
            this.userName = userName;
            this.emailAddress = emailAddress;
            this.password = password;
        }

        public User(int userId,String userName,String emailAddress){
            this.userId = userId;
            this.userName = userName;
            this.emailAddress = emailAddress;
        }

        public int getUserId() {
            return userId;
        }

        public String getUserName() {
            return userName;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public String getPassword() {
            return password;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }

        public void setPassword(String password) {
            this.password = password;
        }
}
