Feature: Project
  @TestItem
  Scenario: As a user I want to create an item to have a list

    Given I have an authentication to todo.ly
    When I send POST request 'api/items.json' with json
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

    When I send PUT request 'api/items/ITEM_ID.json' with json
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
    When I send GET request 'api/items/ITEM_ID.json' with json
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
    When I send DELETE request 'api/items/ITEM_ID.json' with json
    """
    """
    Then I expected the response code 200