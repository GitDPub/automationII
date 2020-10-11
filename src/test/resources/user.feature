Feature: Project
  @TestUser
  Scenario: As a user I want to create a user and edit

    Given I have an authentication to todo.ly
    When I send POST request 'api/user.json' with json
    """
    {
        "Email": "publicpracticas@gmail.com",
        "FullName": "Dieter",
        "Password": "123todo"
    }
    """
    Then I expected the response code 200
    And I expect the response body to be equal to
    """
    {
        "Id": "EXCLUDE",
        "Email": "publicpracticas@gmail.com",
        "Password": null,
        "FullName": "Dieter",
        "TimeZone": 0,
        "IsProUser": false,
        "DefaultProjectId": "EXCLUDE",
        "AddItemMoreExpanded": false,
        "EditDueDateMoreExpanded": false,
        "ListSortType": 0,
        "FirstDayOfWeek": 0,
        "NewTaskDueDate": "EXCLUDE",
        "TimeZoneId": "EXCLUDE"
    }
    """

    And I get the property value 'Id' and save on USER_ID
    And I get the property value 'FullName' and save on USER_NAME

    When I send PUT request 'api/user/USER_ID.json' with json
    """
    {
        "FullName": "USER_NAME updated"
    }
    """
    Then I expected the response code 200

    When I send GET request 'api/authentication/token.json' with json
    """
    """
    Then I expected the response code 200
