
insert into ingredient (name) values ('Egg');
insert into ingredient (name) values ('Milk');
insert into ingredient (name) values ('Yogurt');
insert into ingredient (name) values ('Chicken breast');
insert into ingredient (name) values ('Parmesan');
insert into ingredient (name) values ('Banana');

insert into location (name, continent) values ('Egipat', 'Afrika');
insert into location (name, continent) values ('Indonezija', 'Azija');
insert into location (name, continent) values ('Kina', 'Azija');
insert into location (name, continent) values ('Meksiko', 'Severna Amerika');

insert into recipe (name, popularity, rating, times_eaten, times_viewed, location) values('Scrambled eggs', 0, 0, 0, 0, 1);
insert into recipe (name, popularity, rating, times_eaten, times_viewed, location) values('Fried chicken breasts', 0, 0, 0, 0, 2);
insert into recipe (name, popularity, rating, times_eaten, times_viewed, location) values('Banana cake', 0, 0, 0, 0, 3);

insert into ingredient_recipe (ingredient_id, recipe_id) values (1,1);
insert into ingredient_recipe (ingredient_id, recipe_id) values (1,3);
insert into ingredient_recipe (ingredient_id, recipe_id) values (1,2);
insert into ingredient_recipe (ingredient_id, recipe_id) values (6,3);
insert into ingredient_recipe (ingredient_id, recipe_id) values (4,2);
insert into ingredient_recipe (ingredient_id, recipe_id) values (2,3);

insert into user_model (first_name, last_name, age, username, password, calories_threshold, height, weight, gender, weight_goal) values ('First', 'Last', 23, 'username_test', 'pass_test', 2100, 170, 65, 0, 1);
insert into user_model (first_name, last_name, age, username, password, calories_threshold, height, weight, gender, weight_goal) values ('Second', 'Last', 24, 'username_test2', 'pass_test', 2000, 168, 57, 1, 2);