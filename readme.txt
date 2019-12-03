
the Tests program is uploaded on the Saepiox Github under Tests.
To use it, clone it into your IDE and navigate to src/test/java, where a number of individual tests are located.
/todo: There is  also a master-test there that tries to load data into and verify a fresh install of the saepiox app. Not recommended for general use.

The test program is by default set up to run tests on localhost:5000, for development testing, but it can be pointed at an online instantation of the saepiox program if passed the address and login credentials, either globally in the
"testVariablesPile" file, or in the init section of any individual test.
.
The test program is entirely seperate from the Saepiox code base, it simulates a user interacting with the program via the selenium protocol, (An opensource project supported by volunteers and the companies behind the various webbrowsers),
so in order to run any tests, you also need to be actively running an instance of the saepiox project.

Uses:
Stress and load testing.
Verification code changes did not break functionality.
Development-to-test. When adding new functionality, It may be desirable to first write at least a draft of the test ýou want to run to verify this new function - This is known to be a good way to minimize the number of actions the enduser
will have to take in the browser to use the new function, and keep the user-workflow clean.

Current tests found in the src/test/java folder
Browser-verification:
Description:
This attempts to load every user interface in saepiox into firefox and chrome, screenshots them, and dumps everything into a "tests" folder in your onedrive photo folder, it also complains in the terminal if major problems pop up.
Use: Basic check of fundamental functionality on browsers not róutinely used during development.
Todo: Get this to play nice with move web-drivers.

UserCreationAndDestruction:
Descripton:
Adds the test user "Charles Ponzi" to the system, then erases him from it again.
Use:;basic test, also fails if test does not have System credentials.
TestAgreementStuff: Adds and removes an agreement from the system.
Dashboardread: Checks the data on the dashboard against the file linked in the test.
Use: Verification of saepiox calculations by the use of data with known results.
/todo: Set this up to use a fresh agreement, then clean up after itself.


PositionsImportandVerificaton:
loads positiondata into saepiox then verifies the correctness of the import against its own attempt at reading the data.
use: Test new datasources and imports.
/todo: Generalize importfunction as aggressively as possible.


portfolioimport: Loads a portfolio in, verifies it against own read, see above.
/todo ;Also needs generalizing.
/todo: LimitCreation: Write a test for this, then get limitcreation to work in saepiox.