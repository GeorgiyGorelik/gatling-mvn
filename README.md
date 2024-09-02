How to run the test
1. mvn gatling:test -DENV_URL="https://karens.pythonanywhere.com/" -DvUsers=2 -Dduration=30 -Dgatling.simulationClass=com.epam.performance.tests.examples_api.SwaggerSimulation;
2. open report