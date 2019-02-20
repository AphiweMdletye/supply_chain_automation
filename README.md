# tal-restassured
tal-restassured is a customized API testing framework built by the takealot QA team.
It is based on REST Assured, a Java library that provides a domain-specific language (DSL) for writing powerful, maintainable tests for RESTful APIs.

### Prerequisites
Java 8 +
Gradle 4.0.1 +

## Getting Started
1. Clone the following repository:

## Running the tests

**Local Machine**:

`gradle clean build <task_name>`

e.g. To run api tests for storefront apps public api

`gradle clean build run_takealot` 

**Jenkins CI:**
1. Go to http://jenkins.hq.takealot.com:8080/view/QA%20team/job/TAL_API_Integration_Tests/
2. Click 'Build with Parameters'
3. Select API_HOST and API_VERSION
4. Click Build



### Reporting
**Local Machine**:

`file:///Users/<User>/tal-restassured/build/reports/tests/test/index.html`


**Jenkins CI:**
1. Once the build has finished running
2. View the relevant job e.g. `http://jenkins.hq.takealot.com:8080/view/QA%20team/job/TAL_API_Integration_Tests/<job_number>`
OR the latest report http://jenkins.hq.takealot.com:8080/view/QA%20team/job/TAL_API_Integration_Tests/allure/


