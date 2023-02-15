CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar'

rm -rf student-submission
git clone $1 student-submission
echo 'Finished cloning'

if [ ! -e student-submission/ListExamples.java ]
then
    echo "File ListExamples.java not found"
    exit 1
fi

cp student-submission/ListExamples.java ./

javac ListExamples.java
COMPILE_CODE=$?

if [ $COMPILE_CODE -ne 0 ]
then
    echo "ListExamples.java compile failed with exit code $COMPILE_CODE"
    exit $COMPILE_CODE
fi

javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar TestListExamples.java
COMPILE_CODE=$?

if [ $COMPILE_CODE -ne 0 ]
then
    echo "Tester compile failed with exit code $COMPILE_CODE"
    exit $COMPILE_CODE
fi

java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples
