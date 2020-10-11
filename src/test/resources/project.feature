Feature: Project
  @TestProject
  Scenario: As a user I want to create an item to have a list

    Given I have an authentication to todo.ly
    When I send POST request 'api/projects.json' with json
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

    When I send PUT request 'api/projects/PROJECT_ID.json' with json
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

    When I send GET request 'api/projects/PROJECT_ID.json' with json
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
    When I send DELETE request 'api/projects/PROJECT_ID.json' with json
    """
    """
    Then I expected the response code 200