# ANNOTATION-BASED DEPENDENCY INJECTION

FOR GENERATING THE HASH CODE, IT IS NECESSARY TO LAUNCH THIS COMMAND : 

$ java -cp C:/Users/a73s/.m2/repository/org/jasypt/jasypt/1.9.2/jasypt-1.9.2.jar  org.jasypt.intf.cli.JasyptPBEStringEncryptionCLI input="password" password=jamesmedice algorithm=PBEWithMD5AndDES

----ENVIRONMENT-----------------

Runtime: Oracle Corporation Java HotSpot(TM) 64-Bit Server VM 25.211-b12



----ARGUMENTS-------------------

algorithm: PBEWithMD5AndDES
input: password
password: jamesmedice



----OUTPUT----------------------

qwmgr2rfmtljXlOwzySmKkXdj5iLwjRd



on properties file : 

config:
  db:
    password: ENC(qwmgr2rfmtljXlOwzySmKkXdj5iLwjRd)



the java property

	@Value("${config.db.password}")
	private String password;
	
	
RUNNING : mvn -Djasypt.encryptor.password=jamesmedice   spring-boot:run
	  note that the parameter jasypt.encryptor.password for VM has to match  org.jasypt.intf.cli.JasyptPBEStringEncryptionCLI input="password" password=jamesmedice
	