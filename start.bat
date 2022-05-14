start .\tomcat\bin\shutdown.bat
rm -rf bin/
dir /s /B src\*.java > sources.txt
mkdir bin\WEB-INF\classes
javac  -d bin\WEB-INF\classes @sources.txt -cp lib\javax.servlet-api-4.0.1.jar

cp src\resources\web.xml  bin\WEB-INF\web.xml
cp -a src\resources\jsp\.  bin\jsp\
cp -a src\resources\css\.  bin\css\
cp -a src\resources\js\.  bin\js\

cd bin
jar -cvf tour.war .

cd ..

cp bin\tour.war tomcat\webapps\tour.war
start .\tomcat\bin\startup.bat



