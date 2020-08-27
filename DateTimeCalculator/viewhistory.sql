select dto.time_stamp, ot.inputs, ot.operation, ot.output
from date_time_operation dto
         join operation_transaction ot on dto.operation_transaction_id = ot.id;