package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new com.google.codelabs.mdc.kotlin.shrine.DataBinderMapperImpl());
  }
}
