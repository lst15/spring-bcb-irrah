ALTER TABLE client RENAME COLUMN "Plan_plan_id" TO "plan_id";
ALTER TABLE client RENAME COLUMN "User_user_uuid" TO "user_uuid";

ALTER TABLE public."Message" RENAME COLUMN "User_user_uuid" TO "user_uuid";
ALTER TABLE public."Message" RENAME COLUMN "message_sentAt" TO "message_sentat";

ALTER TABLE Message_has_Platform RENAME COLUMN "Platform_platform_id" TO "platform_id";
ALTER TABLE Message_has_Platform RENAME COLUMN "Message_message_id" TO "message_id";

ALTER TABLE platform RENAME COLUMN "platform_createdAt" TO "platform_createdat";

ALTER TABLE public.user RENAME COLUMN "user_createdAt" TO "user_createdat";

ALTER TABLE public."Message" RENAME TO message;