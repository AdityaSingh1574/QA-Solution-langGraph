Feature: Hartron TestControl Search By Name/Tag

Scenario: Search for Core Java courses in TestControl
    Given user is on TestControl screen
    When enter search text "Core Java" in Search by course-name
    Then verify if records are filtered by checking the count of courses
    And the filtered results should only contain "Core Java" courses

Scenario: Search for Python courses in TestControl
    Given user is on TestControl screen
    When enter search text "Python" in Search by course-name
    Then verify if records are filtered by checking the count of courses
    And the filtered results should only contain "Python" courses