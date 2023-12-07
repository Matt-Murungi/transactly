from django.urls import path
from .views import TransactionListView, DetailedTransactionView, TransactionsByDate

urlpatterns = [
    path("", TransactionListView.as_view(), name="transactions-list"),
    path("<int:id>/", DetailedTransactionView.as_view(), name="transaction-detail"),
    path(
        "filter/",
        TransactionsByDate.as_view(),
        name="transaction-filter",
    ),
]
