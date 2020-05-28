
insert into ingredient (name) values ('Egg');
insert into ingredient (name) values ('Milk');
insert into ingredient (name) values ('Yogurt');
insert into ingredient (name) values ('Chicken breast');
insert into ingredient (name) values ('Parmesan');   --5
insert into ingredient (name) values ('Banana');
insert into ingredient (name) values ('Apple');
insert into ingredient (name) values ('Pineapple');
insert into ingredient (name) values ('Strawberry');
insert into ingredient (name) values ('Blackberry'); --10
insert into ingredient (name) values ('Blueberry');
insert into ingredient (name) values ('Wheat');
insert into ingredient (name) values ('Oats');
insert into ingredient (name) values ('Corn');
insert into ingredient (name) values ('Cornflour'); --15
insert into ingredient (name) values ('Flour');
insert into ingredient (name) values ('Cheese');
insert into ingredient (name) values ('Sourcream');
insert into ingredient (name) values ('Chocolate');
insert into ingredient (name) values ('Cocoa');     --20
insert into ingredient (name) values ('Sausage');
insert into ingredient (name) values ('Bacon');
insert into ingredient (name) values ('Onion');
insert into ingredient (name) values ('Garlic');
insert into ingredient (name) values ('Bell Pepper'); --25
insert into ingredient (name) values ('Chilli Pepper');
insert into ingredient (name) values ('Ground beef');
insert into ingredient (name) values ('Mayonnaise');
insert into ingredient (name) values ('Pickles');
insert into ingredient (name) values ('Tomato');      --30
insert into ingredient (name) values ('Ketchup');
insert into ingredient (name) values ('Salami');
insert into ingredient (name) values ('Cabbage');
insert into ingredient (name) values ('Pickled cabbage');
insert into ingredient (name) values ('Rice');       --35

insert into location (name, continent) values ('Egypt', 'Africa');
insert into location (name, continent) values ('Ethiopia', 'Africa');
insert into location (name, continent) values ('Nigeria', 'Africa');
insert into location (name, continent) values ('Morocco', 'Africa');
insert into location (name, continent) values ('Kenya', 'Africa');     --5
insert into location (name, continent) values ('Indonesia', 'Asia');
insert into location (name, continent) values ('China', 'Asia');
insert into location (name, continent) values ('India', 'Asia');
insert into location (name, continent) values ('Russia', 'Asia');
insert into location (name, continent) values ('Japan', 'Asia');       --10
insert into location (name, continent) values ('Bangladesh', 'Asia');
insert into location (name, continent) values ('Mexico', 'America');
insert into location (name, continent) values ('USA', 'America');
insert into location (name, continent) values ('Canada', 'America');
insert into location (name, continent) values ('Brasil', 'America');   --15
insert into location (name, continent) values ('Argentina', 'America');
insert into location (name, continent) values ('Serbia', 'Europe');
insert into location (name, continent) values ('Germany', 'Europe');
insert into location (name, continent) values ('France', 'Europe');
insert into location (name, continent) values ('Spain', 'Europe');     --20
insert into location (name, continent) values ('Great Britain', 'Europe');
insert into location (name, continent) values ('Australia', 'Oceania');
insert into location (name, continent) values ('New Zealand', 'Oceania');
insert into location (name, continent) values ('Fiji', 'Oceania');


---- RECIPES + MACROS + INGREDIENTS ------------------------------------------------

insert into macronutrients (protein, carbs, fat, calories) values (18, 0, 15, 207);
insert into recipe (name, popularity, rating, times_eaten, times_viewed, location, macros_id) values('Scrambled eggs', 0, 0, 0, 0, 17, 1);
insert into ingredient_recipe (ingredient_id, recipe_id) values (1,1);

insert into macronutrients (protein, carbs, fat, calories) values (35, 5, 28, 412);
insert into recipe (name, popularity, rating, times_eaten, times_viewed, location, macros_id) values('Scrambled eggs with sausage', 0, 0, 0, 0, 18, 2);
insert into ingredient_recipe (ingredient_id, recipe_id) values (1,2);
insert into ingredient_recipe (ingredient_id, recipe_id) values (21,2);

insert into macronutrients (protein, carbs, fat, calories) values (40, 15, 19, 391);
insert into recipe (name, popularity, rating, times_eaten, times_viewed, location, macros_id) values('Omlette', 0, 0, 0, 0, 19, 3);
insert into ingredient_recipe (ingredient_id, recipe_id) values (1,3);
insert into ingredient_recipe (ingredient_id, recipe_id) values (25,3);
insert into ingredient_recipe (ingredient_id, recipe_id) values (23,3);
insert into ingredient_recipe (ingredient_id, recipe_id) values (24,3);

insert into macronutrients (protein, carbs, fat, calories) values (35, 20, 29, 481);
insert into recipe (name, popularity, rating, times_eaten, times_viewed, location, macros_id) values('Fried chicken breasts', 0, 0, 0, 0, 2, 4);
insert into ingredient_recipe (ingredient_id, recipe_id) values (1,4);
insert into ingredient_recipe (ingredient_id, recipe_id) values (4,4);
insert into ingredient_recipe (ingredient_id, recipe_id) values (16,4);


insert into macronutrients (protein, carbs, fat, calories) values (10, 60, 20, 481);
insert into recipe (name, popularity, rating, times_eaten, times_viewed, location, macros_id) values('Banana cake', 0, 0, 0, 0, 3, 5);
insert into ingredient_recipe (ingredient_id, recipe_id) values (1,5);
insert into ingredient_recipe (ingredient_id, recipe_id) values (2,5);
insert into ingredient_recipe (ingredient_id, recipe_id) values (6,5);
insert into ingredient_recipe (ingredient_id, recipe_id) values (16,5);

insert into macronutrients (protein, carbs, fat, calories) values (10, 50, 10, 330);
insert into recipe (name, popularity, rating, times_eaten, times_viewed, location, macros_id) values('Pancake', 0, 0, 0, 0, 3, 6);
insert into ingredient_recipe (ingredient_id, recipe_id) values (1,6);
insert into ingredient_recipe (ingredient_id, recipe_id) values (2,6);
insert into ingredient_recipe (ingredient_id, recipe_id) values (16,6);

insert into macronutrients (protein, carbs, fat, calories) values (10, 75, 10, 430);
insert into recipe (name, popularity, rating, times_eaten, times_viewed, location, macros_id) values('Chocolate pancake', 0, 0, 0, 0, 3, 7);
insert into ingredient_recipe (ingredient_id, recipe_id) values (1,7);
insert into ingredient_recipe (ingredient_id, recipe_id) values (2,7);
insert into ingredient_recipe (ingredient_id, recipe_id) values (16,7);
insert into ingredient_recipe (ingredient_id, recipe_id) values (19,7);

insert into macronutrients (protein, carbs, fat, calories) values (10, 75, 10, 430);
insert into recipe (name, popularity, rating, times_eaten, times_viewed, location, macros_id) values('Berry pancake', 0, 0, 0, 0, 3, 8);
insert into ingredient_recipe (ingredient_id, recipe_id) values (1,8);
insert into ingredient_recipe (ingredient_id, recipe_id) values (2,8);
insert into ingredient_recipe (ingredient_id, recipe_id) values (16,8);
insert into ingredient_recipe (ingredient_id, recipe_id) values (9,8);
insert into ingredient_recipe (ingredient_id, recipe_id) values (10,8);
insert into ingredient_recipe (ingredient_id, recipe_id) values (11,8);

insert into macronutrients (protein, carbs, fat, calories) values (10, 75, 10, 430);
insert into recipe (name, popularity, rating, times_eaten, times_viewed, location, macros_id) values('Hot chocolate', 0, 0, 0, 0, 3, 9);
insert into ingredient_recipe (ingredient_id, recipe_id) values (2,9);
insert into ingredient_recipe (ingredient_id, recipe_id) values (19,9);

insert into macronutrients (protein, carbs, fat, calories) values (10, 75, 10, 430);
insert into recipe (name, popularity, rating, times_eaten, times_viewed, location, macros_id) values('Oatmeal', 0, 0, 0, 0, 3, 10);
insert into ingredient_recipe (ingredient_id, recipe_id) values (2,10);
insert into ingredient_recipe (ingredient_id, recipe_id) values (13,10);

insert into macronutrients (protein, carbs, fat, calories) values (10, 75, 10, 430);
insert into recipe (name, popularity, rating, times_eaten, times_viewed, location, macros_id) values('Fried sausage', 0, 0, 0, 0, 3, 11);
insert into ingredient_recipe (ingredient_id, recipe_id) values (21,11);
insert into ingredient_recipe (ingredient_id, recipe_id) values (23,11);
insert into ingredient_recipe (ingredient_id, recipe_id) values (24,11);

insert into macronutrients (protein, carbs, fat, calories) values (10, 75, 10, 430);
insert into recipe (name, popularity, rating, times_eaten, times_viewed, location, macros_id) values('Hamburger', 0, 0, 0, 0, 3, 12);
insert into ingredient_recipe (ingredient_id, recipe_id) values (27,12);
insert into ingredient_recipe (ingredient_id, recipe_id) values (28,12);
insert into ingredient_recipe (ingredient_id, recipe_id) values (29,12);
insert into ingredient_recipe (ingredient_id, recipe_id) values (30,12);
insert into ingredient_recipe (ingredient_id, recipe_id) values (16,12);
insert into ingredient_recipe (ingredient_id, recipe_id) values (23,12);

insert into macronutrients (protein, carbs, fat, calories) values (10, 75, 10, 430);
insert into recipe (name, popularity, rating, times_eaten, times_viewed, location, macros_id) values('Bacon hamburger', 0, 0, 0, 0, 3, 13);
insert into ingredient_recipe (ingredient_id, recipe_id) values (27,13);
insert into ingredient_recipe (ingredient_id, recipe_id) values (28,13);
insert into ingredient_recipe (ingredient_id, recipe_id) values (29,13);
insert into ingredient_recipe (ingredient_id, recipe_id) values (30,13);
insert into ingredient_recipe (ingredient_id, recipe_id) values (16,13);
insert into ingredient_recipe (ingredient_id, recipe_id) values (23,13);
insert into ingredient_recipe (ingredient_id, recipe_id) values (22,13);

insert into macronutrients (protein, carbs, fat, calories) values (10, 75, 10, 430);
insert into recipe (name, popularity, rating, times_eaten, times_viewed, location, macros_id) values('Cheeseburger', 0, 0, 0, 0, 3, 14);
insert into ingredient_recipe (ingredient_id, recipe_id) values (27,14);
insert into ingredient_recipe (ingredient_id, recipe_id) values (28,14);
insert into ingredient_recipe (ingredient_id, recipe_id) values (29,14);
insert into ingredient_recipe (ingredient_id, recipe_id) values (30,14);
insert into ingredient_recipe (ingredient_id, recipe_id) values (16,14);
insert into ingredient_recipe (ingredient_id, recipe_id) values (23,14);
insert into ingredient_recipe (ingredient_id, recipe_id) values (17,14);

insert into macronutrients (protein, carbs, fat, calories) values (10, 75, 10, 430);
insert into recipe (name, popularity, rating, times_eaten, times_viewed, location, macros_id) values('Bacon cheeseburger', 0, 0, 0, 0, 3, 15);
insert into ingredient_recipe (ingredient_id, recipe_id) values (27,15);
insert into ingredient_recipe (ingredient_id, recipe_id) values (28,15);
insert into ingredient_recipe (ingredient_id, recipe_id) values (29,15);
insert into ingredient_recipe (ingredient_id, recipe_id) values (30,15);
insert into ingredient_recipe (ingredient_id, recipe_id) values (16,15);
insert into ingredient_recipe (ingredient_id, recipe_id) values (23,15);
insert into ingredient_recipe (ingredient_id, recipe_id) values (17,15);
insert into ingredient_recipe (ingredient_id, recipe_id) values (22,15);

insert into macronutrients (protein, carbs, fat, calories) values (10, 75, 10, 430);
insert into recipe (name, popularity, rating, times_eaten, times_viewed, location, macros_id) values('Cornbread', 0, 0, 0, 0, 3, 16);
insert into ingredient_recipe (ingredient_id, recipe_id) values (15,16);
insert into ingredient_recipe (ingredient_id, recipe_id) values (3,16);

insert into macronutrients (protein, carbs, fat, calories) values (10, 75, 10, 430);
insert into recipe (name, popularity, rating, times_eaten, times_viewed, location, macros_id) values('Cornbread with cheese', 0, 0, 0, 0, 3, 17);
insert into ingredient_recipe (ingredient_id, recipe_id) values (15,17);
insert into ingredient_recipe (ingredient_id, recipe_id) values (17,17);
insert into ingredient_recipe (ingredient_id, recipe_id) values (3,17);

insert into macronutrients (protein, carbs, fat, calories) values (10, 75, 10, 430);
insert into recipe (name, popularity, rating, times_eaten, times_viewed, location, macros_id) values('Pizza', 0, 0, 0, 0, 3, 18);
insert into ingredient_recipe (ingredient_id, recipe_id) values (16,18);
insert into ingredient_recipe (ingredient_id, recipe_id) values (17,18);
insert into ingredient_recipe (ingredient_id, recipe_id) values (31,18);
insert into ingredient_recipe (ingredient_id, recipe_id) values (32,18);

insert into macronutrients (protein, carbs, fat, calories) values (10, 75, 10, 430);
insert into recipe (name, popularity, rating, times_eaten, times_viewed, location, macros_id) values('Sausage pizza', 0, 0, 0, 0, 3, 19);
insert into ingredient_recipe (ingredient_id, recipe_id) values (16,19);
insert into ingredient_recipe (ingredient_id, recipe_id) values (17,19);
insert into ingredient_recipe (ingredient_id, recipe_id) values (31,19);
insert into ingredient_recipe (ingredient_id, recipe_id) values (21,19);

insert into macronutrients (protein, carbs, fat, calories) values (10, 75, 10, 430);
insert into recipe (name, popularity, rating, times_eaten, times_viewed, location, macros_id) values('Sarma', 0, 0, 0, 0, 3, 20);
insert into ingredient_recipe (ingredient_id, recipe_id) values (34,20);
insert into ingredient_recipe (ingredient_id, recipe_id) values (35,20);
insert into ingredient_recipe (ingredient_id, recipe_id) values (27,20);

insert into macronutrients (protein, carbs, fat, calories) values (10, 75, 10, 430);
insert into recipe (name, popularity, rating, times_eaten, times_viewed, location, macros_id) values('Sweet cabbage', 0, 0, 0, 0, 3, 21);
insert into ingredient_recipe (ingredient_id, recipe_id) values (33,21);
insert into ingredient_recipe (ingredient_id, recipe_id) values (23,21);
insert into ingredient_recipe (ingredient_id, recipe_id) values (24,21);





insert into user_model (first_name, last_name, age, username, password, calories_threshold, height, weight, gender, weight_goal) values ('First', 'Last', 23, 'username_test', 'pass_test', 2100, 170, 65, 0, 1);
insert into user_model (first_name, last_name, age, username, password, calories_threshold, height, weight, gender, weight_goal) values ('Second', 'Last', 24, 'username_test2', 'pass_test', 2000, 168, 57, 1, 2);