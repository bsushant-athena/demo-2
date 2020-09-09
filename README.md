This is a dummy project for showing usage of sqlite using java jpa.

SCHEMA IS SLACK.DB

//****************
QUESTIONS ASKED:

1)SELECT t.id,t.name,u.email,u.username
from users u join teams t
on t.id = u.team_id
where email="roadrunner@acme.com" and u.deleted=0


2)Write query for Teams that the roadrunner@acme.com user can join
//****************

//****************
Software used for visualizing sqlite db >>> DB browser for sqlite
//****************