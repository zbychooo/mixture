# Create a URL shortening app

## Requirements
Create a URL shortening application in Java that will fulfill the following requirements:
	
	- Create a random and unique short URL for a given input URL.
	- Create a URL with a given shortcut (e.g. http://myVeryLongUrl.com/ThisIsATest to http://smrtcd.rs/myCustomURL).
	- Resolve a short URL to the original URL.
	- Use the following character class: [A-Za-z0-9].
	- All data should be persisted between executions.
	- Application parameters’ (flags) description:
		-i – URL to be shortened
		-o – Shorten a given URL to a URL with a specified alias
		-s – Resolve short URL to original URL

## Input and expected output
A long URL like:
`https://www.google.pl/search?client=safari&rls=en&q=this+is+my+super+long+url+that+you+shold+shorten+as+otherwise+unicorns+will+have+it+for+lunch&ie=UTF-8&oe=UTF-8&gfe_rd=cr&ei=U0pRWKzrM8Pi8AfKjJagBA#q=this+is+my+super+long+url+that+you+should+shorten+as+otherwise+unicorns+will+have+it+for+lunch` 
should be shortened to e.g. `http://smrtcd.rs/a53cvbDD`

## Execution trace
    1. urlsh -i http://mylong-url.com —> smrtcd.rs/rk629eh
    2. urlsh -s smrtcd.rs/rk629eh —> http://mylong-url.com
    3. urlsh -i http://mylong-url.com -o MyString —> http://smrtcd.rs/MyString
    4. urlsh -i http://mylong-url.com —> smrtcd.rs/lakjJJJ
    5. urlsh -i http://my-other-long-url.com -o MyString —> Error: Short URL already in use