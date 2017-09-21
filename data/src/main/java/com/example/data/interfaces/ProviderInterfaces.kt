package com.example.data.interfaces

import com.example.data.DataGetter
import com.example.data.query.TopicQuery
import com.example.data.response.TopicResponse

interface TopicDataProvider : DataGetter<TopicQuery, TopicResponse>