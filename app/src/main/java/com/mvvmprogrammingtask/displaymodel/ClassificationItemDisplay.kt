package com.mvvmprogrammingtask.displaymodel

import android.databinding.ObservableField


data class ClassificationItemDisplay(var isActive : ObservableField<Boolean> = ObservableField(false),val name : String?,val designation: String?,val classification : String?)