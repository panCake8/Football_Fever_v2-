package com.pancake.footballfever.data.local.mappers.VenueMapper

import com.example.footboolfever.data.local.database.entity.VenueEntity
import com.example.footboolfever.data.remote.dto.VenueDto
import com.pancake.footballfever.data.local.mappers.IMapper

class VenueMapper : IMapper<VenueDto, VenueEntity> {
    override fun map(input: VenueDto): VenueEntity {
        return VenueEntity(
            id = input.id,
            country = input.country,
            image = input.image,
            address = input.address,
            city = input.city,
            name = input.name,
            capacity = input.capacity,
        )
    }
}