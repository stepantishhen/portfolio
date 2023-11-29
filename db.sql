DROP TABLE IF EXISTS users;
CREATE TABLE "users" (
        "id" serial PRIMARY KEY,
        "username" varchar NOT NULL,
        "password" varchar NOT NULL,
        "role" varchar NOT NULL DEFAULT 'simpleuser',
        "email" varchar,
        "firstName" varchar,
        "secondName" varchar,
        "phoneNumber" varchar
);

DROP TABLE IF EXISTS booking;
CREATE TABLE booking (
        "id" serial PRIMARY KEY,
        "userid" integer,
        "photostudioid" integer,
        "date" date
);

DROP TABLE IF EXISTS photo_studio;
CREATE TABLE photo_studio (
         "id" serial PRIMARY KEY,
         "title" varchar,
         "description" varchar,
         "image" path,
         "address" varchar,
         "email" varchar,
         "phonenumber" varchar
);

DROP TABLE IF EXISTS review;
CREATE TABLE review (
       "id" serial PRIMARY KEY,
       "userid" integer,
       "text" text,
       "rating" integer,
       "ispublish" boolean DEFAULT true
);

DROP TABLE IF EXISTS file;
CREATE TABLE file (
    "id" serial PRIMARY KEY,
    "original_file_name" varchar,
    "storage_file_name" varchar,
    "size" integer,
    "type" varchar
);
