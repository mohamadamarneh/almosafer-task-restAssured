# almosafer-task-restAssured
Hi there, 
this is Almosafer required task (rest assured).

this is the first time i use rest assured for API testing, usualy i used to use Postman or katalon Studio fo similar tasks but i prefered to use rest assured task as required :) .

-the scenario if make get requist then do TDD in(testdata.json) for POST requist to put the GET response in the body and use it in POST requist.


1-you can run the task from : almosafer/src/test/java/tests/Alomosafer_Tests.java (rigth click -> run TestNG).

2-it will run the GET requiest make smoke test and strcture data assert becuase the data changes in requists.

3-then move the body of response for TestDataLoader.java to procces it in testdata.json.

4-then it will call the data from (testdata.json) and put it in the body of POST requist and send the requist.

5-from POST response it will make smoke test.

6-reports TestNG/Junit in :almosafer/test-output/emailable-report.html , almosafer/test-output/Default suite/Default test.html

note: the task have comments explained the codes and POST_TRIP_INFO.java fils just for make sure TDD works in others classes 


hope you like it.
