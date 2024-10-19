user_stories = [
# """Background: User login at https://mymis.geminisolutions.com/Account/Login
# User Types user id : 'webadmin'
# User types password : 'Gemini@1234' and logs in
# redirect to : https://mymis.geminisolutions.com/
# Scenario Outline : Test for getting report of Employee skills
# User navigates to apply under LNSA
# redirect to : https://mymis.geminisolutions.com/Lnsa/Apply
# User checks week 40 and week 41 for LNSA and clicks submit
# User enters the reason as "Required for company's quick progress" and finally submits"""
# ,
# """Background: User login at https://mymis.geminisolutions.com/Account/Login
# User Types user id : 'webadmin'
# User types password : 'Gemini@1234' and logs in
# redirect to : https://mymis.geminisolutions.com/
# Scenario Outline: Test for adding new asset type on Mymis
# User navigates to manage assets under Asset Allocation
# redirect to : https://mymis.geminisolutions.com/Asset/Manage
# User clicks on Add new asset type
# User gives asset type as "testing123" and Selects yes for Is temporary option and adds it """
# ,
# """Background: User login at https://mymis.geminisolutions.com/Account/Login
# User Types user id : 'webadmin'
# User types password : 'Gemini@1234' and logs in
# redirect to : https://mymis.geminisolutions.com/
# Scenario Outline: Test for updating information about an asset
# User navigates to manage assets under Asset Allocation
# redirect to : https://mymis.geminisolutions.com/Asset/Manage
# User selects edit asset and then changes asset type to CPU and serial number to SRN000089 and updates the asset"""
# ,
# """Background: User login at https://mymis.geminisolutions.com/Account/Login
# User Types user id : 'webadmin'
# User types password : 'Gemini@1234' and logs in
# redirect to : https://mymis.geminisolutions.com/
# Scenario Outline: Test deleting an asset 
# user navigates to manage under asset allocation
# redirect to : https://mymis.geminisolutions.com/Asset/Manage
# user clicks on delete asset and the confirms by "yes"   
# """
# , 
# """Background: User login at https://mymis.geminisolutions.com/Account/Login
# User Types user id : 'webadmin'
# User types password : 'Gemini@1234' and logs in
# redirect to : https://mymis.geminisolutions.com/
# Scenario Outline: Test view, deactivate and delete policy
# user navigates manage policy
# redirect to : https://mymis.geminisolutions.com/Policy/ManagePolicy
# user clicks on view policy
# user clicks on deactivate policy and then confirm yes
# user clicks on delete policy then confirms yes"""

# ,
# """Background: User login at https://mymis.geminisolutions.com/Account/Login
# User Types user id : 'webadmin'
# User types password : 'Gemini@1234' and logs in
# redirect to : https://mymis.geminisolutions.com/
# Scenario Outline : Test adding a new team 
# user navigates to team info under team management
# redirect to : https://mymis.geminisolutions.com/TeamManagement/TeamInformation
# user gives team name as "testing123" and selects weak start day as Tuesday
# user selects department as data science and team head as 123 user
# user saves the new team information"""
# ,
# """Background: User login at https://mymis.geminisolutions.com/Account/Login
# User Types user id : 'webadmin'
# User types password : 'Gemini@1234' and logs in
# redirect to : https://mymis.geminisolutions.com/
# Scenario Outline : Test preview and delete for teams
# user navigates to team info under team management
# redirect to : https://mymis.geminisolutions.com/TeamManagement/TeamInformation
# user clicks view to view team and the clicks delete and confirms"""
# ,
# """Background: User login at https://mymis.geminisolutions.com/Account/Login
# User Types user id : 'webadmin'
# User types password : 'Gemini@1234' and logs in
# redirect to : https://mymis.geminisolutions.com/
# Scenario Outline : Testing Add new task details
# user navigates to manage task sub details under task management
# redirect to : https://mymis.geminisolutions.com/TaskManagement/ManageTaskSubDetail1
# user clicks on add new task details and then gives task name as "testing321" and then adds it"""

# ,
# """
# Background: User login at https://mymis.geminisolutions.com/Account/Login
# User Types user id : 'webadmin'
# User types password : 'Gemini@1234' and logs in
# redirect to : https://mymis.geminisolutions.com/
# Scenario Outline : testing manage team task page
# user navigates to "Manage team task" under task management
# redirect to : https://mymis.geminisolutions.com/TaskManagement/ManageTaskTeam
# user changes the entries to 25
# user searches for "testing 123"
# """,
# """Background: User login at https://mymis.geminisolutions.com/Account/Login
# User Types user id : 'webadmin'
# User types password : 'Gemini@1234' and logs in
# redirect to : https://mymis.geminisolutions.com/
# Scenario Outline : Test adding client 
# user navigates to client management under ec-dc management
# redirect to : https://mymis.geminisolutions.com/EcDcHierarchy/ManageClient
# user adds the client and fills the information client name, address, city and country and adds it
# """,
# """Background: User login at https://mymis.geminisolutions.com/Account/Login
# User Types user id : 'webadmin'
# User types password : 'Gemini@1234' and logs in
# redirect to : https://mymis.geminisolutions.com/
# Scenario Outline : Test search functionality 
# user navigates to client management under ec-dc management
# redirect to : https://mymis.geminisolutions.com/EcDcHierarchy/ManageClient
# user searches for "PIMCO" 
# """
# ,
# """ Background: User login at https://mymis.geminisolutions.com/Account/Login
# User Types user id : 'webadmin'
# User types password : 'Gemini@1234' and logs in
# redirect to : https://mymis.geminisolutions.com/
# Scenario Outline : test  multiple functionalities on feedback page
# user navigates to 'quaterly feedback' under ec-dc management
# redirect to : https://mymis.geminisolutions.com/EcDcHierarchy/NineBox
# selects the first option from financial year and selects Finadvisor from Delivery council
# change the number of entries to 50
# clicks on export to download
# clicks on user manual
# """,
# """Background: User login at https://dev-athena.geminisolutions.com/login
# Given User is at login page
# And User types in email field: "test1234@gmail.com"
# And User types in password field: "test@123" 
# And click on sign in
# Then Redirect to: https://dev-athena.geminisolutions.com/athena/admin/user-dashboard
# Scenario Outline: Validate count on assigning learner
# Given Select "Manage Courses" and "Batches" from sidebar
# Then Redirect to: https://dev-athena.geminisolutions.com/athena/admin/manage-courses/batches
# When Click actions icon of a record "dummy" 
# And Select "Assign Learners" from actions dropdown
# Then Redirect to: https://dev-athena.geminisolutions.com/athena/admin/manage-courses/batches/assign-learners/Ng%3D%3D
# And Get assigned learners count
# And Assign a learner with email "egwuyrx@gmail.com"
# And click on "assign selected" button 
# And Confirm assignment by clicking the "Yes" button
# Then Validate count after assigning
# And Message displayed: "Learner added successfully to the batch"
# """,
# """Background: User login at https://dev-athena.geminisolutions.com/login
# Given User is at login page
# And User types in email field: "test1234@gmail.com"
# And User types in password field: "test@123" 
# And click on sign in
# Then Redirect to: https://dev-athena.geminisolutions.com/athena/admin/user-dashboard
# Scenario Outline: Validate count on unassigning learner
# Given Select "Manage Courses" and "Batches" from sidebar
# Then Redirect to: https://dev-athena.geminisolutions.com/athena/admin/manage-courses/batches
# When Click actions icon of a record "dummy" 
# And Select "Assign Learners" from actions dropdown
# Then Redirect to: https://dev-athena.geminisolutions.com/athena/admin/manage-courses/batches/assign-learners/Ng%3D%3D
# And Get assigned learners count
# And unassign a learner with email "egwuyrx@gmail.com"
# And click on "unassign selected" button
# And Confirm assignment by clicking the "Yes" button
# Then Validate count after unassigning
# And Message displayed: "Learner removed successfully from the batch"
# """
# ,
# """Background: User login at https://dev-athena.geminisolutions.com/login
# Given User is at login page
# And User types in email field: "test1234@gmail.com"
# And User types in password field: "test@123" 
# And click on sign in
# Then Redirect to: https://dev-athena.geminisolutions.com/athena/admin/user-dashboard
# Scenario Outline: Validate assign selected
# Given Select "Manage Courses" and "Batches" from sidebar
# Then Redirect to: https://dev-athena.geminisolutions.com/athena/admin/manage-courses/batches
# When Click actions icon of a record "dummy" 
# And Select "Assign Learners" from actions dropdown
# Then Redirect to: https://dev-athena.geminisolutions.com/athena/admin/manage-courses/batches/assign-learners/Ng%3D%3D
# And Get assigned learners count
# And Select an unassigned learner from current page
# And Go to next page
# And Select an unassigned learner
# And Click "Assign Selected" button
# And Confirm assignment by clicking the "Yes" button
# Then Validate count after assigning learners from multiple pages
# And Message displayed: "All learners added successfully"
# """
# ,
# """Background: User login at https://dev-athena.geminisolutions.com/login
# Given User is at login page
# And User types in email field: "test1234@gmail.com"
# And User types in password field: "test@123" 
# And click on sign in
# Then Redirect to: https://dev-athena.geminisolutions.com/athena/admin/user-dashboard
# Scenario Outline: Filter by status
# Given Select "Manage Courses" and "Batches" from sidebar
# Then Redirect to: https://dev-athena.geminisolutions.com/athena/admin/manage-courses/batches
# When Click actions icon of a record "dummy" 
# And Select "Assign Learners" from actions dropdown
# Then Redirect to: https://dev-athena.geminisolutions.com/athena/admin/manage-courses/batches/assign-learners/Ng%3D%3D
# And Get assigned learners count
# And Expand the "Status" dropdown
# And Select "Assigned" from the dropdown
# Then Validate records filtered by status "Assigned"
# """
# ,
# """
# Background: User login at https://dev-athena.geminisolutions.com/login
# Given User is at login page
# And User types in email field: "test1234@gmail.com"
# And User types in password field: "test@123" 
# And click on sign in
# Then Redirect to: https://dev-athena.geminisolutions.com/athena/admin/user-dashboard
# Scenario Outline: Filter by category
# Given Select "Manage Courses" and "Batches" from sidebar
# Then Redirect to: https://dev-athena.geminisolutions.com/athena/admin/manage-courses/batches
# When Click actions icon of a record "dummy" 
# And Select "Assign Learners" from actions dropdown
# Then Redirect to: https://dev-athena.geminisolutions.com/athena/admin/manage-courses/batches/assign-learners/Ng%3D%3D
# And Get assigned learners count
# And Expand the "Category" dropdown
# And Select "EC" from the dropdown
# And Expand the "selected category" dropdown
# And Select "QA" from the dropdown
# Then Validate records filtered by category "EC" and subcategory "QA"
# """
# ,
# """Background: User login at https://dev-athena.geminisolutions.com/login
# Given User is at login page
# And User types in email field: "test1234@gmail.com"
# And User types in password field: "test@123" 
# And click on sign in
# Then Redirect to: https://dev-athena.geminisolutions.com/athena/admin/user-dashboard
# Scenario Outline: Filter and unassign a candidate
# Given Select "Manage Courses" and "Batches" from sidebar
# Then Redirect to:https://dev-athena.geminisolutions.com/athena/admin/manage-courses/batches
# When Click actions icon of a record "dummy" 
# And Select "Assign Learners" from actions dropdown
# Then Redirect to: https://dev-athena.geminisolutions.com/athena/admin/manage-courses/batches/assign-learners/Ng%3D%3D
# And Expand the "Category" dropdown
# And Select "EC" from the dropdown
# And Expand the "selected category" dropdown
# And Select "QA" from the dropdown
# And Get assigned learners count
# And Unassign a learner from the filtered list
# Then Validate count after unassigning"""
"""
Background: User login at https://mymis.geminisolutions.com/Account/Login
User Types user id : 'webadmin'
User types password : 'Gemini@1234' and logs in
redirect to : https://mymis.geminisolutions.com/
Scenario Outline : 
"""
]


dir_names = [
    # "mymis-apply-lnsa-submit"
    # "mymis-add-asset-type-manage-assets",
    # "mymis-update-asset-allocation",
    # "mymis-delete-asset-manage",
    # "mymis-view-deactivate-delete-policy",
    # "mymis-add-team-management",
    # "mymis-view-delete-teams",
    # "mymis-add-task-details-task-management",
    # "mymis-manage-team-task-search",
    # "mymis-login-add-client",
    # "mymis-search-client-ec-dc",
    # "mymis-feedback-export-manual",
    # "dev-athena-login-assign-learner",
    # "dev-athena-login-unassign-learner",
    # "dev-athena-assign-learners-batches",
    # "dev-athena-login-filter-batches",
    # "dev-athena-login-filter-assign-learners",
    # "dev-athena-login-filter-unassign-candidate"
]