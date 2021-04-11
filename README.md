##IMport CSV FILE
Mock user data generate url
https://www.mockaroo.com/
``
curl --location --request POST 'http://localhost:9191/rest/api/v1/user/saveAll' \
--form 'files=@"/home/ubuntudev/Documents/request_1.csv"' \
--form 'files=@"/home/ubuntudev/Documents/request_2.csv"'
``




