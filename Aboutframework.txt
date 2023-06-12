#brnach name : sparkhtmlreports
1) data is read from excell
2) singleton for ScenarioDetails is used
3) basic cucumber reporting used
4) along with this - reporting is also done in sparthtml reports
5) NOTE : here cucumber version is downgraded from 7.0.0 to 6.8.1 to make it compatible with extent reports
this is
BDD java selenium framework
reporting : currently using cucumber default reporting with images enabled with @AfterTest hooks
to disable images  pass  :-DDISABLE_SCREENSHOT="true"  in vm arguements

Note: for spark extent reports
ExtentCucumberAdapter.addTestStepLog(value); is used to write custom text into gherkin step
