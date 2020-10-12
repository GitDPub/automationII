Feature: Project
  @TestProject
  Scenario Outline: As a user I want to do CRUD operations for projects with basic or token authentication

    Given I have an authentication to todo.ly
    When I send POST request 'api/user.json' using BASIC auth with json
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

    When I send GET request 'api/authentication/token.json' using BASIC auth with json
    """
    """
    Then I expected the response code 200
    And I expect the response body to be equal to
    """
    {
        "TokenString": "EXCLUDE",
        "UserEmail": "publicpracticas@gmail.com",
        "ExpirationTime": "EXCLUDE"
    }
    """
    And I get the property value 'TokenString' and save on USER_TOKEN

    When I send PUT request 'api/user/USER_ID.json' using <authType> auth with json
    """
    {
        "FullName": "USER_NAME updated"
    }
    """
    Then I expected the response code 200

    When I send POST request 'api/projects.json' using <authType> auth with json
    """
    {
       "Content":"TEST_PROJECT_01",
       "Icon": 123
    }
    """
    Then I expected the response code 200
    And I expect the response body to be equal to
    """
    {
        "Id": "EXCLUDE",
        "Content": "TEST_PROJECT_01",
        "ItemsCount": 0,
        "Icon": 123,
        "ItemType": 2,
        "ParentId": null,
        "Collapsed": false,
        "ItemOrder": "EXCLUDE",
        "Children": [],
        "IsProjectShared": false,
        "ProjectShareOwnerName": null,
        "ProjectShareOwnerEmail": null,
        "IsShareApproved": false,
        "IsOwnProject": true,
        "LastSyncedDateTime": "EXCLUDE",
        "LastUpdatedDate": "EXCLUDE",
        "Deleted": false,
        "SyncClientCreationId": null
    }
    """

    And I get the property value 'Id' and save on PROJECT_ID
    And I get the property value 'Content' and save on PROJECT_NAME
    And I get the property value 'Icon' and save on PROJECT_ICON

    When I send PUT request 'api/projects/PROJECT_ID.json' using <authType> auth with json
    """
    {
        "Content": "PROJECT_NAME updated"
    }
    """

    Then I expected the response code 200
    And I expect the response body to be equal to
    """
    {
        "Id": PROJECT_ID,
        "Content": "PROJECT_NAME updated",
        "ItemsCount": 0,
        "Icon": PROJECT_ICON,
        "ItemType": 2,
        "ParentId": null,
        "Collapsed": false,
        "ItemOrder": "EXCLUDE",
        "Children": [],
        "IsProjectShared": false,
        "ProjectShareOwnerName": null,
        "ProjectShareOwnerEmail": null,
        "IsShareApproved": false,
        "IsOwnProject": true,
        "LastSyncedDateTime": "EXCLUDE",
        "LastUpdatedDate": "EXCLUDE",
        "Deleted": false,
        "SyncClientCreationId": null
    }
    """

    When I send GET request 'api/projects/PROJECT_ID.json' using <authType> auth with json
    """
    """
    Then I expected the response code 200
    And I expect the response body to be equal to
    """
    {
        "Id": PROJECT_ID,
        "Content": "PROJECT_NAME updated",
        "ItemsCount": 0,
        "Icon": PROJECT_ICON,
        "ItemType": 2,
        "ParentId": null,
        "Collapsed": false,
        "ItemOrder": "EXCLUDE",
        "Children": [],
        "IsProjectShared": false,
        "ProjectShareOwnerName": null,
        "ProjectShareOwnerEmail": null,
        "IsShareApproved": false,
        "IsOwnProject": true,
        "LastSyncedDateTime":"EXCLUDE",
        "LastUpdatedDate": "EXCLUDE",
        "Deleted": false,
        "SyncClientCreationId": null
    }
    """
    When I send DELETE request 'api/projects/PROJECT_ID.json' using <authType> auth with json
    """
    """
    Then I expected the response code 200

    When I send DELETE request 'api/user/USER_ID.json' using <authType> auth with json
    """
    """
    Then I expected the response code 200
    And I expect the response body to be equal to
    """
    {
        "Id": USER_ID,
        "Email": "publicpracticas@gmail.com",
        "Password": null,
        "FullName": "USER_NAME updated",
        "TimeZone": 0,
        "IsProUser": false,
        "DefaultProjectId": "EXCLUDE",
        "AddItemMoreExpanded": false,
        "EditDueDateMoreExpanded": false,
        "ListSortType": 0,
        "FirstDayOfWeek": 0,
        "NewTaskDueDate": -1,
        "TimeZoneId": "Pacific Standard Time"
    }
    """

    Examples:
      | authType  |
      | BASIC     |
      | TOKEN     |