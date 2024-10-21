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
Scenario Outline : Test add appraisal cycle
user navigates to appraisal cycle in appraisal
redirect to : https://mymis.geminisolutions.com/AppraisalManagement/AppraisalCycle
user adds new appraisal cycle and selects country as india, year as 2021 and month as july 
user saves the appraisal cycle
"""
,
"""
Background: User login at https://mymis.geminisolutions.com/Account/Login
User Types user id : 'webadmin'
User types password : 'Gemini@1234' and logs in
redirect to : https://mymis.geminisolutions.com/
Scenario Outline : Test update appraisal cycle
user navigates to appraisal cycle in appraisal
redirect to : https://mymis.geminisolutions.com/AppraisalManagement/AppraisalCycle
user updates the first appraisal cycle and selects the appraisal month as 2023
user saves the appraisal cycle
"""
,
"""
Background: User login at https://mymis.geminisolutions.com/Account/Login
User Types user id : 'webadmin'
User types password : 'Gemini@1234' and logs in
redirect to : https://mymis.geminisolutions.com/
Scenario Outline : Test delete appraisal cycle
user navigates to appraisal cycle in appraisal
redirect to : https://mymis.geminisolutions.com/AppraisalManagement/AppraisalCycle
user deletes the first appraisal cycle and confirms deleting it.
"""
,
"""
Background: User login at https://mymis.geminisolutions.com/Account/Login
User Types user id : 'webadmin'
User types password : 'Gemini@1234' and logs in
redirect to : https://mymis.geminisolutions.com/
Scenario Outline : Test add new parameter
user navigates to parameter master under appraisal
redirect to  : https://mymis.geminisolutions.com/AppraisalManagement/ParameterMaster
user adds new parameter and selects competency as `Behavioral` and names paramter as `test123` and selects weightage as `3`
user Adds the new parameter
"""
,
"""
Background: User login at https://mymis.geminisolutions.com/Account/Login
User Types user id : 'webadmin'
User types password : 'Gemini@1234' and logs in
redirect to : https://mymis.geminisolutions.com/
Scenario Outline : Test add new parameter
user navigates to parameter master under appraisal
redirect to  : https://mymis.geminisolutions.com/AppraisalManagement/ParameterMaster
user selects  `Behavioral` in for competenty and year as `2017` and status as `Active` and then clicks on search 
"""
,
"""
Background: User login at https://mymis.geminisolutions.com/Account/Login
User Types user id : 'webadmin'
User types password : 'Gemini@1234' and logs in
redirect to : https://mymis.geminisolutions.com/
Scenario Outline : Test search appraisal setting
user navigates to parameter master under appraisal
redirect to  : https://mymis.geminisolutions.com/AppraisalManagement/ParameterMaster
user selects appraisal cycle as  `April 2022` , location as `Canan Tower`, Vertical as `Gemini solutions`, Division, department and team are left as default
User selects Designation as `Senior Software Engineer L2` only and then searches it.
"""
,
"""
Background: User login at https://mymis.geminisolutions.com/Account/Login
User Types user id : 'webadmin'
User types password : 'Gemini@1234' and logs in
redirect to : https://mymis.geminisolutions.com/
Scenario Outline : Test search competency form
user navigates to competency form under appraisal management
redirect to  : https://mymis.geminisolutions.com/AppraisalManagement/CompetencyForm
user selects appraisal cycle as  `April 2022` , location as `Canan Tower`, Vertical as `Gemini solutions`, Division, department and team are left as default
User selects Designation as `Senior Software Engineer L2` and `Senior Software Engineer L1`  and then searches it.
"""
,
"""
Background: User login at https://mymis.geminisolutions.com/Account/Login
User Types user id : 'webadmin'
User types password : 'Gemini@1234' and logs in
redirect to : https://mymis.geminisolutions.com/
Scenario Outline : Test search Manage Team appraisal
user navigates to Manage Team appraisal form under appraisal management
redirect to  : https://mymis.geminisolutions.com/AppraisalManagement/ManageTeamAppraisal
user selects appraisal cycle as  `April 2022` , location as `Canan Tower`, Vertical as `Gemini solutions`, Division, DC Manager, DC Chair and team are left as default
User selects Department as `Human Resource` and then searches it.
"""
,
"""
Background: User login at https://mymis.geminisolutions.com/Account/Login
User Types user id : 'webadmin'
User types password : 'Gemini@1234' and logs in
redirect to : https://mymis.geminisolutions.com/
Scenario Outline : Test search in Employee appraisals
user navigates to Employee appraisal under appraisal management
redirect to  : https://mymis.geminisolutions.com/AppraisalManagement/EmployeesAppraisal
user selects appraisal cycle as  `April 2021` , leave appraisal status, Dc manager as default, choose  Dc chair as `Akshi Khattar` and search
"""
,
"""
Background: User login at https://mymis.geminisolutions.com/Account/Login
User Types user id : 'webadmin'
User types password : 'Gemini@1234' and logs in
redirect to : https://mymis.geminisolutions.com/
Scenario Outline : Test Add Staff member 
user navigates to manager staff member under user management
redirect to  : https://mymis.geminisolutions.com/UserManagement/ManageStaffMember
user adds new staff member and enters name as `test123` , phone number as `234354565` and selects location as `Canan tower` and saves it
"""
,
"""
Background: User login at https://mymis.geminisolutions.com/Account/Login
User Types user id : 'webadmin'
User types password : 'Gemini@1234' and logs in
redirect to : https://mymis.geminisolutions.com/
Scenario Outline : Test Add options in manage meal
user navigates to manage under meal management
redirect to : vhttps://mymis.geminisolutions.com/MealManagement/MealManage
user adds new meal period and enters `test 123` and saves it under meal period tab
user adds  new meal type and enters `test-1234` and saves it under meal type tab
user adds  new meal category and enters `test-1234` and saves it under meal category tab
user adds  new meal dishes and enters `test-1234` and saves it under meal dishes tab 
"""
,
"""
Background: User login at https://mymis.geminisolutions.com/Account/Login
User Types user id : 'webadmin'
User types password : 'Gemini@1234' and logs in
redirect to : https://mymis.geminisolutions.com/
Scenario Outline : Test Add options in meal package
user navigates to meal package under meal management
redirect to : vhttps://mymis.geminisolutions.com/MealManagement/MealPackage
user adds new meal package and selects meal period as `test123` , meal type as `italian` and meal category as `Vegan` and saves it
"""
,
"""
Background: User login at https://mymis.geminisolutions.com/Account/Login
User Types user id : 'webadmin'
User types password : 'Gemini@1234' and logs in
redirect to : https://mymis.geminisolutions.com/
Scenario Outline : Test add role in manage role
user navigates to manage role under Adiministrations
redirect to  : https://mymis.geminisolutions.com/Administrations/ManageRole
user adds a role and enters the name as `test123` and adds role
"""
,
"""
Background: User login at https://mymis.geminisolutions.com/Account/Login
User Types user id : 'webadmin'
User types password : 'Gemini@1234' and logs in
redirect to : https://mymis.geminisolutions.com/
Scenario Outline : Test edit role in manage role
user navigates to manage role under Adiministrations
redirect to  : https://mymis.geminisolutions.com/Administrations/ManageRole
user updates the role `test123`
user changes the name to `test124` and updates the role
"""
,
"""
Background: User login at https://mymis.geminisolutions.com/Account/Login
User Types user id : 'webadmin'
User types password : 'Gemini@1234' and logs in
redirect to : https://mymis.geminisolutions.com/
Scenario Outline : Test edit user role under user role
user navigates to user role under Administrations
redirect to : https://mymis.geminisolutions.com/Administrations/UserRole
user edits the user role for user `123 User`
user selects role as `MIS Administrator` and updates the user role
"""
,
"""
Background: User login at https://mymis.geminisolutions.com/Account/Login
User Types user id : 'webadmin'
User types password : 'Gemini@1234' and logs in
redirect to : https://mymis.geminisolutions.com/
Scenario Outline : Test add navigation menu
user navigates to Manage Menu under Administrations
redirect to : https://mymis.geminisolutions.com/Administrations/ManageMenu
user adds a new navigation menu
user enters menu name, action name, controller name, css class and menu sequence as  `test123`
user toggles select menu and selects is link enabled and is delegatable as true 
user adds the navigation menu  
"""
,
"""
Background: User login at https://mymis.geminisolutions.com/Account/Login
User Types user id : 'webadmin'
User types password : 'Gemini@1234' and logs in
redirect to : https://mymis.geminisolutions.com/
Scenario Outline : Test add Scheduler Action
user navigates to Manage Scheduler under Administrations
redirect to : https://mymis.geminisolutions.com/Administrations/ManageScheduler
user adds scheduler action
user enters the scheduler name,  description, function name 
"""
,
"""
Background: User login at https://mymis.geminisolutions.com/Account/Login
User Types user id : 'webadmin'
User types password : 'Gemini@1234' and logs in
redirect to : https://mymis.geminisolutions.com/
Scenario Outline : Test add designation group
user navigates to Manage designation under HR Portal
redirect to : https://mymis.geminisolutions.com/HRPortal/ManageDesignation
user adds new designation group and enters designation group title as `test1233` and saves it
"""
,
"""
Background: User login at https://mymis.geminisolutions.com/Account/Login
User Types user id : 'webadmin'
User types password : 'Gemini@1234' and logs in
redirect to : https://mymis.geminisolutions.com/
Scenario Outline : Test new department
user navigates to Manage department/teams under HR Portal
redirect to : https://mymis.geminisolutions.com/HRPortal/ManageDepartment
user adds new department and enters department name, department description as `test1233`
user selects department head as `123 User` and division name as `Seekhley` and adds new department
"""
,
"""
Background: User login at https://mymis.geminisolutions.com/Account/Login
User Types user id : 'webadmin'
User types password : 'Gemini@1234' and logs in
redirect to : https://mymis.geminisolutions.com/
Scenario Outline : Test add client in invoice portal
user navigates to invoice portal under Account portal
redirect to : https://mymis.geminisolutions.com/AccountsPortal/InvoiceReport
user adds new client and enters the name as `test123` and saves it 
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
    # "dev-athena-login-filter-unassign-candidate" ,
    "mymis-add-appraisal-cycle-save",
    "mymis-update-appraisal-cycle",
    "mymis-delete-appraisal-cycle",
    "mymis-add-parameter-appraisal",
    "mymis-search-parameter-appraisal",
    "mymis-search-appraisal-parameter-master",
    "mymis-search-competency-appraisal",
    "mymis-search-manage-team-appraisal",
    "mymis-search-employee-appraisals",
    "mymis-add-staff-member-user-management",
    "mymis-manage-meal-add-options",
    "mymis-add-meal-package-save",
    "mymis-manage-role-add-role",
    "mymis-edit-role-manage-role",
    "mymis-edit-user-role-administration",
    "mymis-add-navigation-menu-administrations",
    "mymis-add-scheduler-action-administrations",
    "mymis-add-designation-group-hr-portal",
    "mymis-add-department-hr-portal",
    "mymis-add-client-invoice-portal"
]