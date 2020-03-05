use gzdx;
alter table user modify column phone varchar(200);
update user set idcard = to_base64(AES_ENCRYPT(idcard,'abcdefgabcdefg12')), phone = to_base64(AES_ENCRYPT(phone,'abcdefgabcdefg12'));