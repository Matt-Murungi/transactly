from django.contrib import admin
from .models import Transactions


class TransactionAdmin(admin.ModelAdmin):
    list_display = [
        "id",
        "txfinish",
        "service",
        "amount"
    ]
    list_filter = ["type", "category"]


admin.site.register(Transactions, TransactionAdmin)
