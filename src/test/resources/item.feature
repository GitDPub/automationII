Feature: Project
  @TestItem
  Scenario Outline: As a user I want to do CRUD operations for items with basic or token authentication

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

    When I send POST request 'api/items.json' using <authType> auth with json
    """
    {
        "Content": "New Item 2"
    }
    """
    Then I expected the response code 200
    And I expect the response body to be equal to
    """
    {
    "Id": "EXCLUDE",
    "Content": "New Item 2",
    "ItemType": 1,
    "Checked": false,
    "ProjectId": null,
    "ParentId": null,
    "Path": "",
    "Collapsed": false,
    "DateString": null,
    "DateStringPriority": 0,
    "DueDate": "",
    "Recurrence": null,
    "ItemOrder": null,
    "Priority": 4,
    "LastSyncedDateTime": "EXCLUDE",
    "Children": [],
    "DueDateTime": null,
    "CreatedDate": "EXCLUDE",
    "LastCheckedDate": null,
    "LastUpdatedDate": "EXCLUDE",
    "Deleted": false,
    "Notes": "",
    "InHistory": false,
    "SyncClientCreationId": null,
    "DueTimeSpecified": true,
    "OwnerId": "EXCLUDE"
}
    """

    And I get the property value 'Id' and save on ITEM_ID
    And I get the property value 'Content' and save on ITEM_NAME

    When I send PUT request 'api/items/ITEM_ID.json' using <authType> auth with json
    """
    {
        "Content": "ITEM_NAME updated"
    }
    """

    Then I expected the response code 200
    And I expect the response body to be equal to
    """
    {
      "Id": ITEM_ID,
      "Content": "ITEM_NAME updated",
      "ItemType": 1,
      "Checked": false,
      "ProjectId": null,
      "ParentId": null,
      "Path": "",
      "Collapsed": false,
      "DateString": null,
      "DateStringPriority": 0,
      "DueDate": "",
      "Recurrence": null,
      "ItemOrder": null,
      "Priority": 4,
      "LastSyncedDateTime": "EXCLUDE",
      "Children": [],
      "DueDateTime": null,
      "CreatedDate": "EXCLUDE",
      "LastCheckedDate": null,
      "LastUpdatedDate": "EXCLUDE",
      "Deleted": false,
      "Notes": "",
      "InHistory": false,
      "SyncClientCreationId": null,
      "DueTimeSpecified": true,
      "OwnerId": "EXCLUDE"
    }
    """
    When I send GET request 'api/items/ITEM_ID.json' using <authType> auth with json
    """
    """
    Then I expected the response code 200
    And I expect the response body to be equal to
    """
    {
      "Id": ITEM_ID,
      "Content": "ITEM_NAME updated",
      "ItemType": 1,
      "Checked": false,
      "ProjectId": null,
      "ParentId": null,
      "Path": "",
      "Collapsed": false,
      "DateString": null,
      "DateStringPriority": 0,
      "DueDate": "",
      "Recurrence": null,
      "ItemOrder": null,
      "Priority": 4,
      "LastSyncedDateTime": "EXCLUDE",
      "Children": [],
      "DueDateTime": null,
      "CreatedDate": "EXCLUDE",
      "LastCheckedDate": null,
      "LastUpdatedDate": "EXCLUDE",
      "Deleted": false,
      "Notes": "",
      "InHistory": false,
      "SyncClientCreationId": null,
      "DueTimeSpecified": true,
      "OwnerId": "EXCLUDE"
    }
    """
    When I send DELETE request 'api/items/ITEM_ID.json' using <authType> auth with json
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