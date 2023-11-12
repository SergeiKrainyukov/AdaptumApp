package com.example.adaptumapp.data.repository

import com.example.adaptumapp.data.network.api.AdaptListApi
import com.example.adaptumapp.domain.entity.AdaptPlan
import com.example.adaptumapp.domain.entity.StageFull
import com.example.adaptumapp.domain.entity.StageMin
import com.example.adaptumapp.domain.repository.PlansRepository
import javax.inject.Inject

class PlansRepositoryImpl @Inject constructor(
    private val adaptListApi: AdaptListApi
) : PlansRepository {
    override suspend fun getAdaptPlans(): List<AdaptPlan> {
        return adaptListApi.getAdaptPlans().map { it.toModel() }
    }

    override suspend fun getStages(groupId: Int): List<StageMin> {
        return adaptListApi.getStages(groupId).map { it.toModel() }
    }

    override suspend fun getStage(stageId: Int): StageFull {
        return StageFull(
            title = "Первое знакомство с подчиненными",
            description = "Некоторые компании знакомят новых сотрудников во время инструктажа. После знакомства новичков с культурой и правилами компании, руководитель каждой команды берет своих новых сотрудников и знакомит со своим коллективом. Но есть и компании, где не проводится инструктаж, и новички вынуждены устанавливать знакомства самостоятельно.\n\nНезависимо от того, как ваша новая компания будет интегрировать вас в коллектив, поиск возможностей представить себя коллективу должным образом, создаст прочную основу для совместной и расслабленной работы в первые дни.\n\nПредставляем вам несколько советов, которые помогут вам представиться коллегам и быстро прижиться в новом коллективе.\n\n1. Представление себя должно основываться на окружающей среде\n\nОбратите внимание на обстановку в вашей новой компании и определите, должны ли вы представиться в случайной или официальной форме. Убедитесь, что ваш подход соответствует стилю и культуре организации. Независимо от того, является ли рабочая обстановка спокойной или официальной, вы должны представиться, начав с вашего имени и должности.\n\nПример: «Привет, меня зовут Александр. Я новый финансовый аналитик».\n\nВ более спокойной обстановке ваши коллеги могут ожидать, что вы дадите больше информации о своей карьере, интересах или увлечениях.\n\nПример: «Всем привет! Меня зовут Виктория. Я новый графический дизайнер. Я работала в компании «Monero» последние два года, прежде чем попала в вашу компанию. Вне работы мне нравится заниматься йогой и ходить в бассейн».",
            documentUrl = "http://79.174.94.65/media/file_on_stage/Welcome_to_the_Proscom.docx",
            videoUrl = "https://www.youtube.com/embed/5qLVUO0q644?si=STqZaFN7D-Vlp1Cw"
        )
    }
}