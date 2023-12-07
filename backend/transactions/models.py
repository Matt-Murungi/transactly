from django.db import models


class Transactions(models.Model):
    id = models.BigIntegerField(primary_key=True)
    txfinish = models.DateTimeField(db_column="TxFinish", blank=True, null=True)
    amount = models.BigIntegerField(db_column="Amount", blank=True, null=True)
    type = models.CharField(db_column="Type", blank=True, null=True)
    service = models.CharField(db_column="Service", blank=True, null=True)
    category = models.CharField(db_column="Category", blank=True, null=True)

    class Meta:
        db_table = "transactions"

    def __str__(self):
        return f"{self.id}"
