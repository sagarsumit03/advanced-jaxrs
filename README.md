the difference between mesaageBodyReader and MessagebodyWriter and params.

for a post request we have a URI: webapi/sumit/name1
here name1 is a param value
but in the name1 we are sending a JSON as
{data:"data"...} then this will be in a messageBodyWriter


same for the get request:
we have a URI: webapi/sumit/comment?start=20size=100
here start is a queryparam with value 20 and another queryparam as value 100 named size.
and if we are getting {date:"data....} then this JSON request is MessageBodyReader