start .\tomcat\bin\shutdown.bat
rm -rf bin/
@REM rm rf tomcat\webapps\tour.war
rm -rf sources.txt
dir /s /B src\*.java > sources.txt
mkdir bin\WEB-INF\classes
mkdir bin\WEB-INF\lib
javac  -d bin\WEB-INF\classes @sources.txt -cp lib\javax.servlet-api-4.0.1.jar

cp lib\taglibs-standard-impl-1.2.5.jar  bin\WEB-INF\lib\taglibs-standard-impl-1.2.5.jar
cp lib\taglibs-standard-spec-1.2.5.jar  bin\WEB-INF\lib\taglibs-standard-spec-1.2.5.jar

cp src\resources\web.xml  bin\WEB-INF\web.xml
cp -a src\resources\jsp\.  bin\jsp\
cp -a src\resources\css\.  bin\css\
cp -a src\resources\js\.  bin\js\

cd bin
jar -cvf app.war .

cd ..

rm -rf tomcat\webapps\app.war
rm -rf tomcat\webapps\app
cp bin\app.war tomcat\webapps\app.war
start .\tomcat\bin\startup.bat



