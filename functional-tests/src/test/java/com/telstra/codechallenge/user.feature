Feature: As a developer, I want to test the user URI
	Scenario: Get users with zero-followers
		Given url microserviceUrl
		And path '/users'
		When method GET
		Then status 200
		And match header Content-Type contains 'application/json'
		And match response ==
		""""
		{
			id : '#number'
			login : '#string'
			html_url : '#string'
		}
		""""