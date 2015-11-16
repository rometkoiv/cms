select 
cu.customer
,cu.first_name firstName
,cu.last_name lastName
,cu.identity_code identityCode
,cu.note
,cu.birth_date birthDate
,cu.created
,cu.updated
,empu.first_name ||' '||empu.last_name updatedBy
,empc.first_name ||' '||empc.last_name createdBy

,cg.c_group cgGroup
,cg.name cgName

,adr.cst_address cstAdress
,adr.address address
,adr.address_type addressType
,adr.house
,adr.town_county townCounty
,adr.county
,adr.zip

,ctp.comm_device_type commDeviceType
,ctp.name commDeviceTypeName

,comm.comm_device commDev
,comm.value_text commDevName

from customer cu 
left join employee empu on empu.employee = cu.updated_by
left join employee empc on empc.employee = cu.created_by
left join cst_address adr on adr.customer = cu.customer and adr.address_type = 1
left join comm_device comm on comm.customer = cu.customer
left join comm_device_type ctp on ctp.comm_device_type = comm.comm_device_type
left join customer_group cgx on cgx.customer = cu.customer
left join c_group cg on cg.c_group = cgx.c_group
where
cu.customer is not null
and cu.first_name like'%%'

;